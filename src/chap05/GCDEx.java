package chap05;

import java.util.Scanner;

class GCDEx {
    static int gcd(int x, int y) {
        while(y > 0) {
            int temp = y; //
            y = x % y; // y=나머지
            x = temp; //  x=나누는수
        }

        return x;
    }

    static int gcdArray(int[] arr) {
        int temp = gcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            temp = gcd(temp, arr[i]);
        }

        return temp;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대 공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");   int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");   int y = stdIn.nextInt();
        System.out.println("gcd(x, y) = " + gcd(x, y));
        System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
    }
}
