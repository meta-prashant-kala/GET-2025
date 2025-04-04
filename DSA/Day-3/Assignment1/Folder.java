import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Folder {
    String folderName;
    String parentFolderPath;
    LocalDateTime timeStamp;

    List<Folder> childFolderList = new ArrayList<Folder>();

    /**
     * Constructor to initialise the folder object with folder name, parentfolder
     * path and time of creation
     * 
     * @param folderName       should be of string type
     * @param parentFolderPath should be of string type
     */
    public Folder(String folderName, String parentFolderPath) {
        this.folderName = folderName;
        this.parentFolderPath = parentFolderPath;
        timeStamp = LocalDateTime.now();
    }

    /**
     * Method to get he folder name
     * 
     * @return folder name
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * Method to get the parent folder path
     * 
     * @return parent folder path
     */
    public String getParentFolderPath() {
        return parentFolderPath;
    }

    /**
     * Method to get the child folder list
     * 
     * @return childe folder list
     */
    public List<Folder> getChildFolderList() {
        return childFolderList;
    }

    /**
     * Method to get the time of creation of a folder
     * 
     * @return time stamp of the folder
     */
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    /**
     * Method to create a directory in the virtual cmd
     * 
     * @param childFolderName  should be of string type
     * @param parentFolderPath should be of string type
     * @return true if the directory is created succesfyllu, otherwise false
     */
    public boolean mkdirCommand(String childFolderName, String parentFolderPath) {
        try {
            for (Folder folderObj : getChildFolderList()) {
                if (childFolderName.equals(folderObj.getFolderName())) {
                    System.out.println("Folder with same name already exists");
                    return false;
                }
            }
            Folder childFolder = new Folder(childFolderName, parentFolderPath);
            childFolderList.add(childFolder);
            System.out.println("Folder created succesfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Cannot create a folder");
            return false;
        }
    }

    /**
     * Method to change the directory from the current directory
     * 
     * @param dirName should be of string type
     * @return child directory if directory exists, otherwise null
     */
    public Folder cdCommand(String dirName) {
        for (Folder childDirectory : childFolderList) {
            if (dirName.equals(childDirectory.folderName)) {
                return childDirectory;
            }
        }
        return null;
    }

    /**
     * Method to print the childlist folder names for the current folder
     */
    public void lsCommand() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss a");
        int folderCount = getChildFolderList().size();
        for (Folder folderObj : childFolderList) {
            System.out.println(folderObj.getTimeStamp().format(formatter) + "    " + folderObj.folderName);
        }
        System.out.println("    " + folderCount + " Folder<s>");
    }

    /**
     * Method to find and print the folder in any of the child directories
     * recurrsivly
     * 
     * @param parentDirectory  should be of Folder type holding parent folder
     *                         details
     * @param searchFolderName should be folder name to search
     */
    public void findCommand(Folder parentDirectory, String searchFolderName) {
        if (parentDirectory == null) {
            return;
        }
        for (Folder childDirectory : parentDirectory.getChildFolderList()) {
            if (searchFolderName.contains(childDirectory.getFolderName())) {
                System.out.println(
                        "Folder found At:  " + childDirectory.getParentFolderPath() + childDirectory.getFolderName());
            }
            findCommand(childDirectory, searchFolderName);
        }
    }

    /**
     * Method to print the directory tree from the parent folder where it is called
     * 
     * @param level        should be of int time
     * @param parentFolder should be of Folder type
     */
    public void treeCommand(int level, Folder parentFolder) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.print("└---->");
        System.out.println(parentFolder.getFolderName());
        for (Folder childFolder : parentFolder.getChildFolderList()) {
            treeCommand(level + 1, childFolder);
        }
    }
    
}
