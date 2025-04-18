public class Util {
    public static LinkedList getInitialData(){
        LinkedList linkedListObj = new LinkedList();
        Employee employee1=new Employee("Prashant", 100, 21);
        Employee employee2=new Employee("Devil", 200, 21);
        Employee employee3=new Employee("Saint", 500, 21);
        Employee employee4=new Employee("Zeus", 400, 21);
        Employee employee5=new Employee("Amit", 500, 22);
        linkedListObj.addNode(employee1);
        linkedListObj.addNode(employee3);
        linkedListObj.addNode(employee4);
        linkedListObj.addNode(employee2);
        linkedListObj.addNode(employee5);
        linkedListObj.quickSort();
        return linkedListObj;
    }   
}
