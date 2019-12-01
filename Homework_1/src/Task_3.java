import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of rhomb side ");
        int length = input.nextInt();
        int N = length*2-1;

        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N/2-i || j == i-N/2 || j==i+N/2 || j ==N-i+N/2-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
