package employees;
// package Employees;

public class HR extends Employee {
    

    private int basicSalary = 4000;
    private int bonus = 200;
    private int compensation = 4500;

    public HR(String empName, String empRole){
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
