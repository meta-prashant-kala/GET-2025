package employees;

public class Designer extends Employee {

    private int basicSalary = 8000;
    private int bonus = 400;
    private int compensation = 9000;

    public Designer(String empName, String empRole){
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
