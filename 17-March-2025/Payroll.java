import employees.Employee;

public class Payroll {

    /**
     * Method to calculate tax on the basic salary
     * 
     * @param employee should be of Employee type holding employee details
     * @return value tax (10% tax on basic salary)
     */
    public int calculateTax(Employee employee) {
        return (employee.getBasicSalary() * (10)) / 100;
    }

    /**
     * Method to print the salary slip of an employee
     * 
     * @param employee should be of Employee type holding employee details
     */
    public void printSalary(Employee employee) {
        int salary = employee.getBasicSalary() + employee.getBonus() + employee.getCompensation();
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Bonus: " + employee.getBonus());
        System.out.println("Compensation: " + employee.getCompensation());
        System.out.println("Tax: " + this.calculateTax(employee));
        System.out.println("----------------------------------------------------");
        System.out.println("Credited Salary: " + (salary - this.calculateTax(employee)));
    }
}
