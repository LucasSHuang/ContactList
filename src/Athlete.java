public class Athlete extends Person {

    // Instance variables
    private String sport;

    // Constructor
    public Athlete(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    // Getter
    public String getSport() {
        return sport;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}
