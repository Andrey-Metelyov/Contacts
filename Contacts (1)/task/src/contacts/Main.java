package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nEnter action (add, remove, edit, count, list, exit):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    count();
                    break;
                case "info":
                    info();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private static void list() {
        int counter = 1;
        for (Contact contact : contacts) {
            System.out.println(counter++ + ". " + contact.getName());
        }
    }

    private static void info() {
        list();
        System.out.println("Enter index to show info:");
        int index = Integer.parseInt(scanner.nextLine());
        showContact(contacts.get(index - 1));
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
            contacts.add(person);
        } else if ("organization".equals(type)) {
            contact = new Organization();
            Organization organization = (Organization) contact;
            System.out.print("Enter the organization name: ");
            organization.setName(scanner.nextLine());
            System.out.print("Enter the address: ");
            organization.setAddress(scanner.nextLine());
            System.out.print("Enter the number: ");
            organization.setNumber(scanner.nextLine());
            contacts.add(organization);
        }
        System.out.println("The record added.");
    }

    private static void remove() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            info();
            System.out.print("Select a record: ");
            int number = Integer.parseInt(scanner.nextLine());
            contacts.remove(number - 1);
            System.out.println("The record removed!");
        }
    }

    private static void edit() {
        if (contacts.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            list();
            System.out.print("Select a record: ");
            int number = Integer.parseInt(scanner.nextLine());
            Contact contact = contacts.get(number - 1);
            if (contact.isPerson()) {
                Person person = (Person) contact;
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                String field = scanner.nextLine();
                switch (field) {
                    case "name":
                        System.out.print("Enter name: ");
                        person.setName(scanner.nextLine());
                        break;
                    case "surname":
                        System.out.print("Enter surname: ");
                        person.setSurname(scanner.nextLine());
                        break;
                    case "birth":
                        System.out.print("Enter birthdate: ");
                        person.setBirthday(scanner.nextLine());
                        break;
                    case "gender":
                        System.out.print("Enter gender: ");
                        person.setGender(scanner.nextLine());
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        person.setNumber(scanner.nextLine());
                        break;
                }
            } else {
                Organization organization = (Organization) contact;
                System.out.print("Select a field (name, address, number): ");
                String field = scanner.nextLine();
                switch (field) {
                    case "name":
                        System.out.print("Enter name: ");
                        organization.setName(scanner.nextLine());
                        break;
                    case "address":
                        System.out.print("Enter address: ");
                        organization.setAddress(scanner.nextLine());
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        organization.setNumber(scanner.nextLine());
                        break;
                    default:
                        System.out.println("ERROR");
                }
            }
            contacts.set(number - 1, contact);
            System.out.println("The record updated!");
        }
    }

    private static void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }
}
