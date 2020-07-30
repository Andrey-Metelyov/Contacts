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
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
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
                case "list":
                    list();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private static void list() {
        int counter = 1;
        for (Contact contact : contacts) {
            System.out.println(counter++ + ". "
                    + contact.getName() + " "
                    + contact.getSurname() + ", "
                    + contact.getNumber());
        }
    }

    private static void add() {
        Contact contact = new Contact();
        System.out.print("Enter the name: ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        contact.setSurname(scanner.nextLine());
        System.out.print("Enter the number: ");
        contact.setNumber(scanner.nextLine());
        contacts.add(contact);
        System.out.println("The record added.");
    }

    private static void remove() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            list();
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
            System.out.print("Select a field (name, surname, number): ");
            String field = scanner.nextLine();
            Contact contact = contacts.get(number - 1);
            switch (field) {
                case "name":
                    System.out.print("Enter name: ");
                    contact.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.print("Enter surname: ");
                    contact.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.print("Enter number: ");
                    contact.setNumber(scanner.nextLine());
                    break;
            }
            contacts.set(number - 1, contact);
            System.out.println("The record updated!");
        }
    }

    private static void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }
}
