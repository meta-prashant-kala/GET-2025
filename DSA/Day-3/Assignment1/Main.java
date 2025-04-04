import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    // Method to move from one directory to another
    public static void moveToDir(Folder parentFolder) {
        String inputCommand;
        List<String> splittedInputCommandList;

        while (true) {
            // Printing the folder path
            if (parentFolder.getParentFolderPath() != null) {
                System.out.print("R:" + parentFolder.getParentFolderPath() + parentFolder.getFolderName() + ">");
            } else {
                System.out.print("R:" + parentFolder.getFolderName());
            }

            // Taking the command as user input
            try {
                inputCommand = scanInput.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a valid command");
                continue;
            }

            // Splitting the command on the basis of space
            splittedInputCommandList = new ArrayList<String>(Arrays.asList(inputCommand.split(" ")));

            // Handling the commands
            switch (splittedInputCommandList.get(0)) {

                case "cd":
                    if (splittedInputCommandList.size() < 2) {
                        System.out.println("Please enter a valid command");
                        continue;
                    }
                    Folder childFolder = parentFolder.cdCommand(splittedInputCommandList.get(1));
                    if (childFolder != null) {
                        moveToDir(childFolder);
                    } else {
                        System.out.println("No such directory exsist");
                    }
                    break;

                case "mkdir":
                    if (splittedInputCommandList.size() < 2) {
                        System.out.println("Please enter a valid command");
                        continue;
                    }
                    if (parentFolder.getParentFolderPath() != null) {
                        parentFolder.mkdirCommand(splittedInputCommandList.get(1),
                                parentFolder.getParentFolderPath() + parentFolder.getFolderName() + "\\");
                    } else {
                        parentFolder.mkdirCommand(splittedInputCommandList.get(1), parentFolder.getFolderName());
                    }
                    break;

                case "bk":
                    if (parentFolder.getParentFolderPath() == null) {
                        System.out.println("Already in the parent directory");
                        break;
                    }
                    return;

                case "ls":
                    parentFolder.lsCommand();
                    break;

                case "find":
                    if (splittedInputCommandList.size() < 2) {
                        System.out.println("Please enter a valid command");
                        continue;
                    }
                    parentFolder.findCommand(parentFolder, splittedInputCommandList.get(1));
                    break;

                case "tree":
                    parentFolder.treeCommand(0, parentFolder);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }

        }

    }

    public static void main(String args[]) {
        Folder parentFolder = new Folder("\\", null);
        moveToDir(parentFolder);

    }
}