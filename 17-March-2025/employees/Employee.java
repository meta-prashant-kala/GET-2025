package employees;

import util.Util;

public abstract class Employee {
    public abstract int getBasicSalary();

    public abstract int getBonus();

    public abstract int getCompensation();

    public abstract String getRole();

    public String employeeName;
    public String employeeRole;

    @Override
    public boolean equals(Object o) {
        Employee emp = (Employee) o;
        if (!Util.isStringEqual(emp.employeeName, this.employeeName)) {
            return false;
        }
        if (!Util.isStringEqual(emp.employeeName, this.employeeName)) {
            return false;
        }

        return true;
    }
}
