import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime date2 = LocalDateTime.parse(scanner.nextLine());
        if (date1.isAfter(date2)) {
            LocalDateTime tmp = date1;
            date1 = date2;
            date2 = tmp;
        }
        int num = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 0; i < num; i++) {
            LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
            if (date.compareTo(date1) >= 0 && date.isBefore(date2)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}