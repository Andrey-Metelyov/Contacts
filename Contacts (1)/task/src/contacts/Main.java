package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        menu();
        System.out.println("A record created!\n" +
                "A Phone Book with a single record created!");
    }

    private static void menu() {
        while (true) {
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
            System.out.println(counter + ". "
                    + contact.name + " "
                    + contact.surname + ", "
                    + contact.number);
        }
    }

    private static void add() {
        Contact contact = new Contact();
        System.out.print("Enter the name: ");
        contact.name = scanner.nextLine();
        System.out.print("Enter the surname: ");
        contact.surname = scanner.nextLine();
        System.out.print("Enter the number: ");
        contact.number = scanner.nextLine();
        contacts.add(contact);
        System.out.println("The record added.");
    }

    private static void remove() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
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
        }
    }

    private static void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }
}
