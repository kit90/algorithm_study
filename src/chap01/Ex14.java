package chap01;

public class Ex14 {
    public static void main(String[] args) {
        triangleRB(8);
    }

    static void triangleLU(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        /* for (int j = n; j >= 1; j--) {
            System.out.printf("%" + n + "s", "*".repeat(j));
            System.out.println();
        } */

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        /* for (int i = 1; i <= n; i++) {
            System.out.printf("%" + n + "s", "*".repeat(i));
            System.out.println();
        } */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
