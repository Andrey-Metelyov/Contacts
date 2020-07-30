import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        final int minutes = Integer.parseInt(scanner.nextLine());
        dateTime = dateTime.plusMinutes(minutes);
        System.out.print(dateTime.getYear() + " " + dateTime.getDayOfYear() + " ");
        if (dateTime.getSecond() > 0) {
            System.out.println(dateTime.toLocalTime());
        } else {
            System.out.println(dateTime.toLocalTime().toString().substring(0, 5));
        }
    }
}