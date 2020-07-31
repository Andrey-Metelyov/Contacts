package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Contact {
    private String name;
    private String number;
    private LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;
    protected boolean person;

    Contact() {
        number = "[no number]";
        timeCreated = LocalDateTime.now().withSecond(0).withNano(0);
        timeLastEdit = timeCreated;
    }

    Contact(String name, String number) {
        this.name = name;
        setNumber(number);
    }

    public boolean isPerson() {
        return person;
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

    protected void updateLastEditTime() {
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public void setName(String name) {
        updateLastEditTime();
        this.name = name;
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

    public static void main(String[] args) {
        Contact c = new Person("1", "2", "+(with space)");
        System.out.println(c.getNumber());
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        updateLastEditTime();
        this.address = address;
    }
}
