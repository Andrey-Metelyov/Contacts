import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        if (time.getSecond() == 0) {
            time = time.minusSeconds(time.getSecond());
        }
        System.out.println(time.toString().substring(0, 5));
    }
}