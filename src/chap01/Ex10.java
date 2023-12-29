package chap01;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("양의 정수의 자릿수를 구합니다.");

        int num;

        do {
            System.out.print("양의 정수 입력>");
            num = stdIn.nextInt();
        } while (num < 0);

        int digit = 0;
        while (num > 0) {
            digit++;
            num /= 10;
        }

        System.out.println("자릿수: " + digit);
    }
}
