package chap01;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정사각형을 출력합니다");
        System.out.print("변의 길이>");
        int length = stdIn.nextInt();


        /* for(int i = 0; i < length; i++) {
            System.out.println("*".repeat(length));
        } */
        for(int i = 1; i <= length; i++) {
            for(int j = 1; j <= length; j ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
