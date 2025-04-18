public class Employee  implements Comparable<Employee>{
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

    @Override
    public int compareTo(Employee o) {
        if(this.salary > o.salary){
            return 1;
        } else if(this.salary == o.salary && this.age < o.age){
            return 1;
        } else if(this.salary == o.salary && this.age == o.age){
            return 0;
        } else{
            return -1;
        }
    }

    

}
