package chap01;

public class Ex11 {
    public static void main(String[] args) {
        System.out.print("   |");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println(System.lineSeparator() + "---+-" + ("---".repeat(9)));

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
            System.out.print("|");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}
