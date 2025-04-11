import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList linkedListObj = new LinkedList();
        int selectedOption;

        while (true) {
            System.out.println();
            System.out.println("1. To enter data to the link list");
            System.out.println("2. To display the linked list");
            System.out.println("3. To rotate the sublist of a list");
            System.out.println("4. To detect a loop in a linkedlist");
            System.out.println("0. To exit from the app");
            System.out.println();
            try {
                selectedOption=Integer.parseInt(scanInput.nextLine());
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please select a valid option");
                continue;
            }
            switch (selectedOption) {
                case 1:
                    try {
                        System.out.println("Enter the value to insert");
                        int val=Integer.parseInt(scanInput.nextLine());
                        linkedListObj.insertNode(val);
                        System.out.println(val+" added to the linked list succesfully");
                    } catch (Exception e) {
                        System.out.println("Enter valid integers");
                        continue;
                    }
                    break;
                case 2:
                    if(linkedListObj.getHead()==null){
                        System.out.println("LinkedList is empty");
                    }
                    else{
                        linkedListObj.displayLinkedList();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter the start point");
                        int left=Integer.parseInt(scanInput.nextLine());
                        System.out.println("Enter the end point");
                        int right=Integer.parseInt(scanInput.nextLine());
                        System.out.println("Number of rotation");
                        int n=Integer.parseInt(scanInput.nextLine());
                        linkedListObj.rotateSublist(left, right, n);
                        linkedListObj.displayLinkedList();
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                     catch (Exception e) {
                        System.out.println("Please enter valid integers");
                    }
                    break;
                case 4:
                    if(linkedListObj.isLoop()){
                        System.out.println("Loop is present in the linked list");
                    }else {
                        System.out.println("No loop is present in the linked list");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
            System.out.println();

        }


    }
}
