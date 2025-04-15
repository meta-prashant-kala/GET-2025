public class Employee {
    String name;
    int salary;
    int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Employee other = (Employee) o;

        return this.salary == other.salary && this.age == other.age && this.name.equals(other.name);
    }

}
