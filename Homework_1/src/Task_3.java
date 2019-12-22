import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of rhomb side ");
        int length = input.nextInt();
        int n = length * 2 - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n / 2 - i || j == i - n / 2 || j == i + n / 2 || j == n - i + n / 2 - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
