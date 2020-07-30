import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int seconds = Integer.parseInt(scanner.nextLine());
        LocalTime time = LocalTime.ofSecondOfDay(seconds);
        if (time.getSecond() != 0) {
            System.out.println(time);
        } else {
            System.out.println(time.toString().substring(0, 5));
        }
    }
}