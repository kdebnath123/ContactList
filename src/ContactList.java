import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    // Holds contact list
    ArrayList<Person> Contacts;

    // Constructs contact List
    public ContactList() {
        Contacts = new ArrayList<Person>();
    }

    // Gets all contacts
    public ArrayList<Person> getContacts() {
        return Contacts;
    }

    // Prompts and creates user for new contact
    public void addContact() {
        Scanner input = new Scanner(System.in);

        System.out.println( "Select a type of contact to add:\n" +
                            "1. Student\n" +
                            "2. Teacher\n");

        int type = input.nextInt();
        input.nextLine();

        System.out.println( "Please fill in the following information.\n" +
                            "First Name:\n");
        String firstName = input.nextLine();

        System.out.println("Last Name: ");
        String lastName = input.nextLine();

        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();

        if(type == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();
            Student s = new Student(firstName, lastName, phoneNumber, grade);
            Contacts.add(s);
        }
        else {
            System.out.println("Salary: ");
            int salary = input.nextInt();
            input.nextLine();
            Teacher t = new Teacher(firstName, lastName, phoneNumber, salary);
            Contacts.add(t);
        }

    }

    // Prints all contacts
    public void printContacts() {

        for (Person p: Contacts){
            System.out.println(p);
        }
    }

    // Sorts Contacts with bubble sort
    public void sort(int sortBy) {

        boolean swapped = false;

        String current = null;
        String next = null;

        for (int i = 0; i < Contacts.size() - 1; i++) {
            for (int j = 0; j < Contacts.size() - i - 1; j++) {
                swapped = false;

                // Choose which attribute to sort by based on inputed #
                switch (sortBy) {
                    // First name
                    case 0:
                        current = Contacts.get(j).getFirstName();
                        next = Contacts.get(j + 1).getFirstName();
                        break;
                    // Last Name
                    case 1:
                        current = Contacts.get(j).getLastName();
                        next = Contacts.get(j + 1).getLastName();
                        break;

                    // Phone Number
                    case 2:
                        current = Contacts.get(j).getPhoneNumber();
                        next = Contacts.get(j + 1).getPhoneNumber();
                        break;
                }

                if (current.compareTo(next) > 0){
                    Contacts.set(j + 1, Contacts.set(j, Contacts.get(j + 1)));
                    swapped = true;
                }
            }

            // If no swaps made, the list is already sorted
            if (!(swapped)){
                break;
            }

        }

    }


    // Searches first names for specified name
    public Person searchByFirstName(String firstName) {
        for (Person p : Contacts){
            if( p.getFirstName().equals(firstName)){
                return p;
            }
        }

        return null;

    }

    // Searches last names for specified name
    public Person searchByLastName(String lastName) {
        for (Person p : Contacts){
            if( p.getLastName().equals(lastName)){
                return p;
            }
        }

        return null;

    }

    // Searches phone numbers for specified number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : Contacts){
            if( p.getPhoneNumber().equals(phoneNumber)){
                return p;
            }
        }

        return null;
    }

    // Prints only students
    public void listStudents() {

        for ( Person p : Contacts){
            if ( p instanceof Student){
                System.out.println(p);
            }
        }
    }

    // Controls primary loop
    public void run() {

        Scanner s = new Scanner(System.in);
        int input = 0;

        while(true){


            System.out.print("Menu:\n" +
                        "1. Add Contact\n" +
                        "2. List All Contacts By First Name\n" +
                        "3. List All Contacts By Last Name\n" +
                        "4. List All Contacts By Phone Number\n" +
                        "5. List All Students\n" +
                        "6. Search By First Name\n" +
                        "7. Search By Last Name\n" +
                        "8. Search by Phone Number\n" +
                        "0. Exit\n");

            input = s.nextInt();
            s.nextLine();

            String lookingFor;
            Person found;



            switch (input){

                case 1:
                    addContact();
                    break;

                case 2:
                case 3:
                case 4:
                    sort(input - 2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:

                    System.out.println("Enter a first name:");
                    lookingFor = s.nextLine();
                    found = searchByFirstName(lookingFor);

                    if(found == null){
                        System.out.println(lookingFor + "is not in the list.");
                    }
                    else{
                        System.out.println(found);
                    }
                    break;

                case 7:
                    System.out.println("Enter a last name:");
                    lookingFor = s.nextLine();
                    found = searchByLastName(lookingFor);

                    if(found == null){
                        System.out.println(lookingFor + " is not in the list.");
                    }
                    else{
                        System.out.println(found);
                    }
                    break;

                case 8:
                    System.out.println("Enter a phone number:");
                    lookingFor = s.nextLine();
                    found = searchByPhoneNumber(lookingFor);

                    if(found == null){
                        System.out.println(lookingFor + " is not in the list.");
                    }
                    else{
                        System.out.println(found);
                    }
                    break;
                case 0:
                    return;
            }

        }
    }

    // Main function
    public static void main(String[] args) {
        ContactList book = new ContactList();
        book.run();
    }
}
