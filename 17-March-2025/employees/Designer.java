package employees;

public class Designer extends Employee {

    private int basicSalary = 8000;
    private int bonus = 400;
    private int compensation = 200;

    /**
     * Constructor to initiate Designer object
     * 
     * @param empName should be of string type
     * @param empRole should be of string type
     */
    public Designer(String empName, String empRole) {
        this.employeeName = empName;
        this.employeeRole = empRole;
    }

    /**
     * method to get the basic salary of an employee
     * 
     * @return basic salary of employee
     */
    public int getBasicSalary() {
        return basicSalary;
    }

    /**
     * method to get the bonus of an employee
     * 
     * @return bouns of the employee
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * method to get the compensation of an employee
     * 
     * @return compensation of the employee
     */
    public int getCompensation() {
        return compensation;
    }

    /**
     * Method to get the role of an employee
     * 
     * @return role of the employee with String type
     */
    public String getRole() {
        return this.employeeRole;
    }

}
