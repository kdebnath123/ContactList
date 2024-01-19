public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Contructs Person
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Get First Name;
    public String getFirstName() {
        return firstName;
    }
    // Set First Name;
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get Last Name
    public String getLastName() {
        return lastName;
    }

    // Set Last Name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set Phone Number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    // Formats Person information for printing
    public String toString(){
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
