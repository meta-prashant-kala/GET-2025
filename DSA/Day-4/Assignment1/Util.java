public class Util {
    public static EmployeeFunction getInitialEmployeeFunctionObj(){
        
        Employee employeeObj1 = new Employee(3, "Prashant", "This is address-1");
        Employee employeeObj2 = new Employee(5, "Ankit", "This is address - 2");
        Employee employeeObj3 = new Employee(1, "Pranjal", "This is address - 3");
        Employee employeeObj4 = new Employee(4, "Rahul", "This is address - 4");
        Employee employeeObj5 = new Employee(2, "Digambar", "This is address - 5");

        EmployeeFunction employeeFunctionObj=new EmployeeFunction();
        employeeFunctionObj.addEmployee(employeeObj1);
        employeeFunctionObj.addEmployee(employeeObj2);
        employeeFunctionObj.addEmployee(employeeObj3);
        employeeFunctionObj.addEmployee(employeeObj4);
        employeeFunctionObj.addEmployee(employeeObj5);

        return employeeFunctionObj;

    }
}
