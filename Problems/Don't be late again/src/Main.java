import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] values = scanner.nextLine().split(" ");
            if (LocalTime.parse(values[1]).isAfter(LocalTime.parse("20:00"))) {
                System.out.println(values[0]);
            }
        }
    }
}