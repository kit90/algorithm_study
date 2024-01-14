package chap05;

import java.util.Scanner;

public class GCDArrayEx {
    static int gcd(int x, int y) {
        while(y > 0) {
            int temp = y; //
            y = x % y; // y=나머지
            x = temp; //  x=나누는수
        }

        return x;
    }

    static int gcdArray(int[] arr) {
        int no = arr.length;
        int temp = gcd(arr[0], arr[1]);

        if (no == 1)
            return arr[0];
        else if (no == 2)
            return temp;
        else {
            for (int i = 2; i < arr.length; i++) {
                temp = gcd(temp, arr[i]);
            }
            return temp;
        }
    }

    //--- 요솟수가 n인 배열 a의 모든 요소의 최대 공약수를 구합니다 ---//
    static int gcdArray2(int a[], int start, int no) {
        if (no == 1)
            return a[start];
        else if (no == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray2(a, start + 1, no - 1));
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("몇 개 정수의 최대 공약수를 구할까요? : ");
        int num;
        do {
            num = stdIn.nextInt();
        } while (num <= 1);

        int[] x = new int[num];					// 길이가 num 인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x) + "입니다.");
    }
}
