package contacts;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Phonebook phonebook;
//    static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        phonebook = new Phonebook();
        if (args.length > 0) {
            String filename = args[0];
            System.out.println("open " + filename);
            phonebook.deserialize(filename);
        }
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "search":
                    search();
                    break;
                case "count":
                    count();
                    break;
                case "info":
//                    info();
                    break;
                case "remove":
//                    remove();
                    break;
                case "edit":
//                    edit();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private static void search() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        List<Contact> search = phonebook.search(query);
        showContacts(search);
        System.out.print("\n[search] Enter action ([number], back, again): ");
        String action = scanner.nextLine();
        switch (action) {
            case "back":
                return;
            case "again":
                break;
        }
        int index = Integer.parseInt(action);
        Contact contact = search.get(index - 1);
        contact.show();
        showRecordMenu(contact);
    }

    private static void showContacts(List<Contact> contacts) {
        int counter = 1;

        for (Contact contact : contacts) {
            System.out.println(counter++ + ". " + contact.getDescName());
        }
    }

    private static void list() {
        showContacts(phonebook.getContacts());
        System.out.print("\n[list] Enter action ([number], back): ");
        String action = scanner.nextLine();
        if ("back".equals(action)) {
            return;
        }
        int index = Integer.parseInt(action);
        Contact contact = phonebook.get(index - 1);
        contact.show();
        showRecordMenu(contact);
    }

    private static void showRecordMenu(Contact contact) {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String action = scanner.nextLine();
        switch (action) {
            case "edit":
                contact.editMenu(scanner);
                break;
            case "delete":
            case "menu":
                break;
        }
    }

    private static void showContact(Contact contact) {
        if (contact.getClass() == Person.class) {
            Person person = (Person) contact;
            System.out.println("Name: " + person.getName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Birth date: " + person.getBirthday());
            System.out.println("Gender: " + person.getGender());
        } else if (contact.getClass() == Organization.class) {
            Organization organization = (Organization) contact;
            System.out.println("Organization name: " + organization.getName());
            System.out.println("Address: " + organization.getAddress());
        }
        System.out.println("Number: " + contact.getNumber());
        System.out.println("Time created: " + contact.getTimeCreated());
        System.out.println("Time Time last edit: " + contact.getTimeLastEdit());
    }

    private static void add() {
        Contact contact;
        System.out.println("Enter the type (person, organization):");
        String type = scanner.nextLine();
        if ("person".equals(type)) {
            contact = new Person();
            Person person = (Person) contact;
            System.out.print("Enter the name: ");
            person.setName(scanner.nextLine());
            System.out.print("Enter the surname: ");
            person.setSurname(scanner.nextLine());
            System.out.print("Enter the birth date: ");
            person.setBirthday(scanner.nextLine());
            System.out.print("Enter the gender: ");
            person.setGender(scanner.nextLine());
            System.out.print("Enter the number: ");
            person.setNumber(scanner.nextLine());
            phonebook.add(person);
        } else if ("organization".equals(type)) {
            contact = new Organization();
            Organization organization = (Organization) contact;
            System.out.print("Enter the organization name: ");
            organization.setName(scanner.nextLine());
            System.out.print("Enter the address: ");
            organization.setAddress(scanner.nextLine());
            System.out.print("Enter the number: ");
            organization.setNumber(scanner.nextLine());
            phonebook.add(organization);
        }
        System.out.println("The record added.");
    }

    private static void remove() {
        if (phonebook.count() == 0) {
            System.out.println("No records to remove!");
        } else {
            showContacts(phonebook.getContacts());
            System.out.print("Select a record: ");
            int number = Integer.parseInt(scanner.nextLine());
            phonebook.remove(number - 1);
            System.out.println("The record removed!");
        }
    }

//    private static void edit() {
//        if (phonebook.count() == 0) {
//            System.out.println("No records to edit!");
//        } else {
//            list();
//            System.out.print("Select a record: ");
//            int number = Integer.parseInt(scanner.nextLine());
//            Contact contact = phonebook.get(number - 1);
//            if (contact.isPerson()) {
//                Person person = (Person) contact;
//                System.out.print("Select a field (name, surname, birth, gender, number): ");
//                String field = scanner.nextLine();
//                switch (field) {
//                    case "name":
//                        System.out.print("Enter name: ");
//                        person.setName(scanner.nextLine());
//                        break;
//                    case "surname":
//                        System.out.print("Enter surname: ");
//                        person.setSurname(scanner.nextLine());
//                        break;
//                    case "birth":
//                        System.out.print("Enter birthdate: ");
//                        person.setBirthday(scanner.nextLine());
//                        break;
//                    case "gender":
//                        System.out.print("Enter gender: ");
//                        person.setGender(scanner.nextLine());
//                        break;
//                    case "number":
//                        System.out.print("Enter number: ");
//                        person.setNumber(scanner.nextLine());
//                        break;
//                }
//            } else {
//                Organization organization = (Organization) contact;
//                System.out.print("Select a field (name, address, number): ");
//                String field = scanner.nextLine();
//                switch (field) {
//                    case "name":
//                        System.out.print("Enter name: ");
//                        organization.setName(scanner.nextLine());
//                        break;
//                    case "address":
//                        System.out.print("Enter address: ");
//                        organization.setAddress(scanner.nextLine());
//                        break;
//                    case "number":
//                        System.out.print("Enter number: ");
//                        organization.setNumber(scanner.nextLine());
//                        break;
//                    default:
//                        System.out.println("ERROR");
//                }
//            }
//            phonebook.set(number - 1, contact);
//            System.out.println("The record updated!");
//        }
//    }

    private static void count() {
        System.out.println("The Phone Book has " + phonebook.count() + " records.");
    }
}
