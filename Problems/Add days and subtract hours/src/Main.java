import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        final LocalDateTime dateTime = LocalDateTime.parse(parts[0]);
        int days = Integer.parseInt(parts[1]);
        int hours = Integer.parseInt(parts[2]);
        System.out.println(dateTime.plusDays(days).minusHours(hours));
    }
}