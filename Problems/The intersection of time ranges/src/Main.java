import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] range1 = scanner.nextLine().split(" ");
        String[] range2 = scanner.nextLine().split(" ");
        LocalTime time11 = LocalTime.parse(range1[0]);
        LocalTime time12 = LocalTime.parse(range1[1]);
        LocalTime time21 = LocalTime.parse(range2[0]);
        LocalTime time22 = LocalTime.parse(range2[1]);
        System.out.println(
                time11.isAfter(time21) && time11.isBefore(time22) || time11.equals(time22) ||
                        time21.isAfter(time11) && time21.isBefore(time12) || time21.equals(time12)
        );

    }
}