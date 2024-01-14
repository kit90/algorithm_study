package chap05;

import java.util.Scanner;

public class RecurCount {
    static int count = 0;

    static void recur(int n) {
        count++;
        if (n > 0) {
            recur(n - 1);
            System.out.print(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);
        System.out.println("count = " + count);
    }
}
