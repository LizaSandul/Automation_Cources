import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number ");
        int day = input.nextInt();

        if ((day>=1) & (day<=7))
        {
            String nameOfTheDay = dayOfTheWeek(day);
            System.out.print(nameOfTheDay);
        }
        else
            System.out.print("The week has only 7 days");
    }

    public static String dayOfTheWeek (int day){
        String[] allNames = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return allNames[day-1];
    }
}
