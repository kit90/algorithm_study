import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = sc.nextInt();

        System.out.print("  |");
        for (int i = 0; i < num; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println("\n---+"+"---".repeat(num));

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i == j) {
                    System.out.print("  |");
                    System.out.print(" ".repeat(2*i));
                }
            }

            for (int j = 0; j < num; j++) {
                System.out.printf("%2d", j);
            }
            System.out.println("  |");
        }
    }
}
