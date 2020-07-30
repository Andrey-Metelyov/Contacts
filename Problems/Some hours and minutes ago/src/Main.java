import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        LocalTime time = LocalTime.parse(first);
        time = time.minusHours(hours).minusMinutes(minutes);
        if (time.getSecond() != 0) {
            System.out.println(time);
        } else {
            System.out.println(time.toString().substring(0, 5));
        }
    }
}