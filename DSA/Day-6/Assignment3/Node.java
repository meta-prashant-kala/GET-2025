public class Node {
    Employee employeeData;
    Node next;

    public Node(Employee employee) {
        employeeData = employee;
        next = null;
    }
    public Employee getEmployeeData() {
        return employeeData;
    }
    public void setEmployeeData(Employee employeeData) {
        this.employeeData = employeeData;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Node other = (Node) o;

        return this.employeeData.equals(other.employeeData);
    }


}
