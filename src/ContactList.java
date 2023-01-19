import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // Array of  contacts
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner s = new Scanner(System.in);
        Person p;
        int choice = 0;
        while (choice < 1 || choice > 2) {
            System.out.println("Select a type of contact to add: \n1. Student \n2. Worker");
            choice = s.nextInt();
        }

        System.out.println("Please fill in the following information.\nFirst Name: ");
        s.nextLine();
        String firstName = s.nextLine();
        s.nextLine();
        System.out.println("Last Name: ");
        String lastName = s.nextLine();
        s.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = s.nextLine();
        s.nextLine();

        if (choice == 1) {
            System.out.println("Grade: ");
            int grade = s.nextInt();
            p = new Student(firstName, lastName, phoneNumber, grade);
        }
        else {
            System.out.println("Salary: ");
            int salary = s.nextInt();
            p = new Worker(firstName, lastName, phoneNumber, salary);
        }

        contacts.add(p);
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (Person p: contacts) {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int n = contacts.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // sort by first name
                if (sortBy == 0) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        // swap
                        Person p = contacts.remove(j);
                        contacts.add(j + 1, p);
                    }
                }
                // sort by last name
                else if (sortBy == 1) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        // swap
                        Person p = contacts.remove(j);
                        contacts.add(j + 1, p);
                    }
                }
                // sort by phone number
                else if (sortBy == 2) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        // swap
                        Person p = contacts.remove(j);
                        contacts.add(j + 1, p);
                    }
                }
            }
        }
        return;
    }
    public Person searchByFirstName(String name) {
        for (Person p: contacts) {
            if (p.getFirstName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person p: contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p: contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (Person p: contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");

        // TODO: Complete the run method
        Scanner s = new Scanner (System.in);
        int input = 1;
        while (input != 0) {
            printMenuOptions();
            input = s.nextInt();
            s.nextLine();
            if (input == 1) {
                addContact();
            }
            else if (input == 2) {
                sort(0);
                printContacts();
            }
            else if (input == 3) {
                sort(1);
                printContacts();
            }
            else if (input == 4) {
                sort(2);
                printContacts();
            }
            else if (input == 5) {
                listStudents();
            }
            else if (input == 6) {
                System.out.println("Enter a name:");
                String name = s.nextLine();

                if (searchByFirstName(name) == null)
                    System.out.println(name + " is not in the list.");
                else
                    System.out.println(searchByFirstName(name));
            }
            else if (input == 7) {
                System.out.println("Enter a last name:");
                String name = s.nextLine();

                if (searchByLastName(name) == null)
                    System.out.println(name + " is not in the list.");
                else
                    System.out.println(searchByLastName(name));
            }
            else if (input == 8) {
                System.out.println("Enter a phone number:");
                String number = s.nextLine();

                if (searchByPhoneNumber(number) == null)
                    System.out.println(number + " is not in the list.");
                else
                    System.out.println(searchByPhoneNumber(number));
            }
            s.nextLine();
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
