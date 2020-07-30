import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(dateTime.plusHours(11).toLocalDate());
    }
}