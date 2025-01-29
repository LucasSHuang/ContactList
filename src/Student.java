public class Student extends Person {

    // Instance variables
    private int grade;

    // Constructor
    public Student (String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getters
    public int getGrade() {
        return grade;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
