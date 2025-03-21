package employees;
// package Employees;

public class Developer extends Employee {

    private int basicSalary = 10000;
    private int bonus = 500;
    private int compensation = 400;

    public Developer(String empName, String empRole) {
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
        return "Developer";
    }
}
