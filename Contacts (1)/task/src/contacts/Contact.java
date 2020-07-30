package contacts;

public class Contact {
    private String name;
    private String surname;
    private String number;

    Contact() {
        number = "[no number]";
    }

    Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String[] groups = number.split("-|\\s");

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
        Contact c = new Contact("1", "2", "+(with space)");
        System.out.println(c.getNumber());
    }
}
