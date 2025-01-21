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
    public void addContact(Person person) {
        contacts.add(person);
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

    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++) {

        }
    }



    // Prints menu
    public void printMenu() {
        System.out.println("Welcome to your contacts list");
        System.out.println("Please pick from the following menu options\n\n");
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
        printMenu();
        int choice = -1;
        while (choice != 0) {
            try {
                choice = scanner.nextInt();
                if (choice > 0 && choice < 8) {
                    if (choice == 1) {
                        System.out.println("Select a type of contact to add");
                        System.out.println();

                    }
                    else if (choice == 2) {
                        sort(0);
                    }
                    else if (choice == 3) {
                        sort(1);
                    }
                    else if (choice == 4) {
                        sort(2);
                    }
                    else if (choice == 5) {

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
        ContactList c = new ContactList();
        c.run();
    }


}

