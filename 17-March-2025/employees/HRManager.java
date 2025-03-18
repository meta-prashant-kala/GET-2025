package employees;
// package Employees;

public class HRManager extends Employee {
    
    private int basicSalary = 6000;
    private int bonus = 300;
    private int compensation = 6500;

    public HRManager(String empName, String empRole){
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
