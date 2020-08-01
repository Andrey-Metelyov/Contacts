import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        LocalDateTime latest = LocalDateTime.parse(scanner.nextLine());
        for (int i = 1; i < num; i++) {
            LocalDateTime current = LocalDateTime.parse(scanner.nextLine());
            if (current.isAfter(latest)) {
                latest = current;
            }
        }
        System.out.println(latest);
    }
}