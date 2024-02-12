package chap06;

import java.util.Scanner;

public class InsertSortBinary {
    static void insertSortEx9(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            int target = arr[i];

            int insertIdx = binSearch(arr, i-1, target);

            int j;
            for (j = i; j > insertIdx; j--) {
                arr[j] = arr[j-1];
            }

            arr[insertIdx] = target;
        }
    }

    static int binSearch(int[] arr, int size, int key) {
        int resultIdx = 0;

        int startIdx = 0;
        int endIdx = size-1;
        int centerIdx;

        do {
            centerIdx = (startIdx + endIdx) / 2; // 소숫점 이하 버림
            if(arr[centerIdx] == key) {
                break; //종료조건1
            }
            else if(arr[centerIdx] > key) endIdx = centerIdx - 1;
            else startIdx = centerIdx + 1;
        } while (startIdx <= endIdx); //종료조건2

        resultIdx = (startIdx <= endIdx) ? centerIdx + 1 : endIdx + 1;

        return resultIdx;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("이진삽입정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertSortEx9(x, nx);			// 배열 x를 이진삽입정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
