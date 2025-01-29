public class Person {

    // Instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString
    public String toString() {
        return firstName + " " + lastName + " - " + phoneNumber;
    }
}
