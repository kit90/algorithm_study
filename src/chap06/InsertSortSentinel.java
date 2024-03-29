package chap06;

import java.util.Scanner;

public class InsertSortSentinel {
    static void insertSortEx8(int[] a, int size) {
        for (int i = 2; i < size; i++) {
            int tmp = a[i];
            a[0] = a[i];

            int j;
            for (j = i; a[j - 1] > tmp; j--) // j > 0 조건 삭제
                a[j] = a[j - 1];

            //본래 j == 0 인 순간은 tmp가 제일 작은, 맨 앞에 오는 순간
            if (j > 0) a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순삽입정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx + 1];						// 여분으로 1개 더 생성

        for (int i = 1; i <= nx; i++) {				// x[1]~x[nx]에 입력 받음
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertSortEx8(x, nx + 1);							// 배열 x를 단순삽입정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 1; i <= nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
