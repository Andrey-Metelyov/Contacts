import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        LocalDate date = LocalDate.parse(input[0]);
        LocalDate nextYear = date.withDayOfYear(1).plusYears(1);
        int days = Integer.parseInt(input[1]);
        System.out.println(date.plusDays(days).equals(nextYear));
    }
}