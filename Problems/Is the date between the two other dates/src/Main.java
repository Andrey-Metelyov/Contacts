import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] dates = line.split(" ");
        LocalDate x = LocalDate.parse(dates[0]);
        LocalDate m = LocalDate.parse(dates[1]);
        LocalDate n = LocalDate.parse(dates[2]);
        System.out.println(x.compareTo(m) > 0 && x.compareTo(n) < 0 ||
                x.compareTo(m) < 0 && x.compareTo(n) > 0);
    }
}