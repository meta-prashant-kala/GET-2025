
class Employee implements Comparable<Employee>{
    public int employeeID;
    public String employeeName;
    public String employeeAddress;


    /**
     * Constructor to initialise the employee class
     * @param empID should be of int type
     * @param empName should be of String type
     * @param empAddr should be of String type
     */
    public Employee(int empID, String empName, String empAddr){
        employeeID=empID;
        employeeName=empName;
        employeeAddress=empAddr;
    }

    /**
     * Overriding the custom compareTo operator for Employee class
     */
    @Override
    public int compareTo(Employee empObj) {
        return this.employeeID-empObj.employeeID;
    }
}