package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact implements MenuHandler {
    protected boolean person;
    private String name;
    private String number;
    private LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    Contact() {
        number = "[no number]";
        timeCreated = LocalDateTime.now().withSecond(0).withNano(0);
        timeLastEdit = timeCreated;
    }

    Contact(String name, String number) {
        this.name = name;
        setNumber(number);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Number: " + number + '\n' +
                "Time created: " + timeCreated + '\n' +
                "Time last edit: " + timeLastEdit + '\n';
    }

    protected void updateLastEditTime() {
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public static void main(String[] args) {
        Contact c = new Person("1", "2", "+(with space)");
        System.out.println(c.getNumber());
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String[] groups = number.split("-|\\s");

        updateLastEditTime();
        if (groups[0].matches("\\+?((\\([\\d\\w]{1,}\\))|([\\d\\w]{1,}))")) {
            if (groups.length == 1) {
                this.number = number;
                return;
            }
            if (groups[1].matches("\\(?[\\d\\w]{2,}\\)?") &&
                    ((groups[0].contains("(") ^ groups[1].contains("(")) ||
                            !groups[0].contains("(") && !groups[1].contains("("))) {
                for (int i = 2; i < groups.length; i++) {
                    if (!groups[i].matches("[\\d\\w]{2,}")) {
                        this.number = "[no number]";
                        return;
                    }
                }
                this.number = number;
                return;
            }
        }
        this.number = "[no number]";
    }

    public String getTimeCreated() {
        return timeCreated.toString();
    }

    public String getTimeLastEdit() {
        return timeLastEdit.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        updateLastEditTime();
        this.name = name;
    }

    @Override
    public List<String> listFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("number");
        return fields;
    }

    @Override
    public void changeField(String field, String value) {
        switch (field) {
            case "name":
                name = value;
                break;
            case "number":
                number = value;
                break;
            default:
                System.out.println("ERROR");
        }
    }

    @Override
    public String getField(String field) {
        switch (field) {
            case "name":
                return name;
            case "number":
                return number;
            default:
                System.out.println("ERROR");
                return "";
        }
    }

    public void show() {
        System.out.println(this.toString());
    }

    public void editMenu(Scanner scanner) {
        System.out.print("Select a field (" + listFields().toString() + "): ");
        String field = scanner.nextLine();
        System.out.print("Enter " + field);
        String value = scanner.nextLine();
        changeField(field, value);
    }

    public boolean contains(String query) {
        return name.toUpperCase().contains(query.toUpperCase()) ||
                number.toUpperCase().contains(query.toUpperCase());
    }

    public String getDescName() {
        return name;
    }
}

class Person extends Contact {
    private String surname;
    private LocalDate birthday;
    private String gender;

    Person() {
        super();
        person = true;
    }

    Person(String name, String surname, String number) {
        super(name, number);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + '\n' +
                "Surname: " + getSurname() + '\n' +
                "Birth date: " + getBirthday() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Number: " + getNumber() + '\n' +
                "Time created: " + getTimeCreated() + '\n' +
                "Time last edit: " + getTimeLastEdit() + '\n';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        updateLastEditTime();
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday == null ? "[no data]" : birthday.toString();
    }

    public void setBirthday(LocalDate birthday) {
        updateLastEditTime();
        this.birthday = birthday;
    }

    public void setBirthday(String birthday) {
        updateLastEditTime();
        try {
            this.birthday = LocalDate.parse(birthday);
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            this.birthday = null;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        updateLastEditTime();
        if ("M".equals(gender) || "F".equals(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    @Override
    public List<String> listFields() {
        List<String> fields = super.listFields();
        fields.add("surname");
        fields.add("birthday");
        fields.add("gender");
        return fields;
    }

    @Override
    public void changeField(String field, String value) {
        super.changeField(field, value);
        switch (field) {
            case "surname":
                surname = value;
                break;
            case "birthday":
                setBirthday(value);
                break;
            case "gender":
                setGender(value);
                break;
            default:
                System.out.println("ERROR");
        }
    }

    @Override
    public String getField(String field) {
        String value = super.getField(field);
        switch (field) {
            case "surname":
                return surname;
            case "birthday":
                return getBirthday();
            case "gender":
                return getGender();
            default:
                System.out.println("ERROR");
        }
        return value;
    }

    public boolean contains(String query) {
        return super.contains(query) ||
                surname.toUpperCase().contains(query.toUpperCase());
    }

    public String getDescName() {
        return getName() + " " + getSurname();
    }
}

class Organization extends Contact {
    private String address;

    Organization() {
        super();
        person = false;
    }

    Organization(String name, String address, String number) {
        super(name, number);
        this.address = address;
    }

    public String toString() {
        return "Organization name: " + getName() + '\n' +
                "Address: " + address + '\n' +
                "Number: " + getNumber() + '\n' +
                "Time created: " + getTimeCreated() + '\n' +
                "Time last edit: " + getTimeLastEdit() + '\n';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        updateLastEditTime();
        this.address = address;
    }
    @Override
    public List<String> listFields() {
        List<String> fields = super.listFields();
        fields.add("address");
        return fields;
    }

    @Override
    public void changeField(String field, String value) {
        super.changeField(field, value);
        switch (field) {
            case "address":
                address = value;
                break;
            default:
                System.out.println("ERROR");
        }
    }

    @Override
    public String getField(String field) {
        String value = super.getField(field);
        switch (field) {
            case "address":
                return address;
        }
        return value;
    }

    public boolean contains(String query) {
        return super.contains(query) ||
                address.toUpperCase().contains(query.toUpperCase());
    }

    public String getDescName() {
        return getName();
    }
}
