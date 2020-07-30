import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int offset = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.parse(input);
        int currentYear = date.getYear();
        do {
            System.out.println(date);
            date = date.plusDays(offset);
        } while (date.getYear() == currentYear);
    }
}