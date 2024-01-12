public class Teacher extends Person{

    public int salary;

    // Constructs Teacher
    public Teacher(String firstName, String lastName, String phoneNumber, int salary) {
        super(firstName, lastName, phoneNumber);
        this.salary = salary;
    }

    // Get Salary
    public int getSalary() {
        return salary;
    }

    // Set Salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    // Formats Student information for printing
    public String toString(){
        return super.toString() + " Salary: $" + salary;

    }
}
