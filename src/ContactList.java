// Contact List by Lucas Huang

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactList {

    // Instance variables
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Getter
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds new contacts
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a type of contact to add");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        // Makes sure user puts in an integer
        boolean validInput = false;
        while (!validInput) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                // If the user puts in a wrong integer
                if (choice == 1 || choice == 2) {
                    // Gets the first name, last name, and phone number
                    System.out.println("Please fill out the following information");
                    System.out.println("First Name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Last Name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Phone Number:");
                    String phoneNumber = scanner.nextLine();
                    // Now switches between student and athlete class
                    if (choice == 1) {
                        System.out.println("Grade:");
                        // Makes sure student types an integer and valid grade number
                        boolean nextInput = false;
                        while (!nextInput) {
                            try {
                                int grade = scanner.nextInt();
                                if (grade >= 1 && grade <= 12) {
                                    Student s1 = new Student(firstName, lastName, phoneNumber, grade);
                                    contacts.add(s1);
                                    validInput = true;
                                    nextInput = true;
                                }
                                else {
                                    System.out.println("Please type a grade between 1 and 12");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please type an integer");
                                scanner.nextLine();
                            }
                        }
                    }
                    else {
                        System.out.println("Sport:");
                        String sport = scanner.nextLine();
                        Athlete a1 = new Athlete(firstName, lastName, phoneNumber, sport);
                        contacts.add(a1);
                        validInput = true;
                    }
                }
                else {
                    System.out.println("Please type 1 or 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please type an integer");
                scanner.nextLine();
            }
        }
    }

    // Prints the contacts
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    // Sorts contacts by name or phone number
    public void sort(int method) {
        int length = contacts.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (method == 0) {
                    // Sorts by first name
                    // Compares to see which first name goes first
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        swap(j, j + 1);
                    }
                }
                else if (method == 1) {
                    // Sort by last name
                    // Same as before but compares last name
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        swap(j, j + 1);
                    }
                }
                else {
                    // Sort by phone number
                    // Compares phone number
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        swap(j, j + 1);
                    }
                }
            }

        }
    }

    // Swaps the two people in the ArrayList
    public void swap(int p1, int p2) {
        Person tempPerson = contacts.get(p2);
        contacts.set(p2, contacts.get(p1));
        contacts.set(p1, tempPerson);
    }

    // Search methods for first name, last name, and phone number
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    // Prints out all students
    public void listStudents() {
        for (Person p: contacts) {
            // Uses instanceof to make sure it is a student
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }



    // Prints menu
    public void printMenu() {
        System.out.println("Welcome to your contacts list");
        System.out.println("Please pick from the following menu options\n");
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }

    // Runs
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        // Makes sure it runs until user inputs 0
        while (choice != 0) {
            // Checks to make sure you put in an int
            try {
                // Prints menu and makes sure you put in right number
                printMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > 0 && choice < 9) {
                    if (choice == 0) {
                        break;
                    }
                    else if (choice == 1) {
                        addContact();
                    }
                    else if (choice == 2) {
                        sort(0);
                        printContacts();
                    }
                    else if (choice == 3) {
                        sort(1);
                        printContacts();
                    }
                    else if (choice == 4) {
                        sort(2);
                        printContacts();
                    }
                    else if (choice == 5) {
                        listStudents();
                    }
                    else if (choice == 6) {

                        System.out.println("First Name:");
                        String firstName = scanner.nextLine();
                        Person p = searchByFirstName(firstName);
                        // If person is not in contact list says so
                        if (p == null) {
                            System.out.println("First Name Not In Contact List");
                        }
                        else {
                            System.out.println(p);
                        }
                    }
                    else if (choice == 7) {
                        System.out.println("Last Name:");
                        String lastName = scanner.nextLine();
                        Person p = searchByLastName(lastName);
                        if (p == null) {
                            System.out.println("Last Name Not In Contact List");
                        }
                        else {
                            System.out.println(p);
                        }
                    }
                    else if (choice == 8){
                        System.out.println("Phone Number:");
                        String phoneNumber = scanner.nextLine();
                        Person p = searchByPhoneNumber(phoneNumber);
                        if (p == null) {
                            System.out.println("Phone Number Not In Contact List");
                        }
                        else {
                            System.out.println(p);
                        }
                    }
                }
                else {
                    System.out.println("Type a number on the menu");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please type an integer");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        // Creates contact list and runs the menu
        ContactList c = new ContactList();
        c.run();
    }


}

