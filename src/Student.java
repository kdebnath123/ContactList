public class Student extends Person{

    private int grade;

    // Constructs Student
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Get Grade
    public int getGrade() {
        return grade;
    }

    // Set Grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    // Formats Student information for printing
    public String toString(){
        return super.toString() + " Grade: " + grade;
    }
}
