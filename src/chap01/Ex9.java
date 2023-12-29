package chap01;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("두 정수의 차이를 구합니다. b는 a를 초과해야합니다.");
        
        System.out.print("a값 입력>");
        int a = stdIn.nextInt();
        int b;
        
        do {
            System.out.print("b값 입력>");
            b = stdIn.nextInt();
        } while (b <= a);

        System.out.println("차이: " + (b-a));
    }
}
