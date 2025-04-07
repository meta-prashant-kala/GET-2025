
class Employee implements Comparable<Employee>{
    public int employeeID;
    public String employeeName;
    public String employeeAddress;

    public Employee(int empID, String empName, String empAddr){
        employeeID=empID;
        employeeName=empName;
        employeeAddress=empAddr;
    }

    @Override
    public int compareTo(Employee empObj) {
        return this.employeeID-empObj.employeeID;
    }
}