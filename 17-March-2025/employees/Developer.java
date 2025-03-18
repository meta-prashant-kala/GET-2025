package employees;
// package Employees;

public class Developer extends Employee {

    private int basicSalary = 10000;
    private int bonus = 500;
    private int compensation = 11000;

    public Developer(String empName, String empRole){
        this.employeeName=empName;
        this.employeeRole=empRole;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public int getCompensation() {
        return compensation;
    }

}
