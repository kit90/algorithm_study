package chap06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void backwardBubbleSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) { //모든 요소
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    static void forwardBubbleSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) { //모든 요소
            for (int j = size - 1; j > i; j--) {
                if(arr[j] < arr[j-1])
                    swap(arr, j, j-1);
            }
        }
    }

    static void forwardBubbleSortProcess(int[] arr, int size) {
        int compareCnt = 0;
        int swapCnt = 0;
        for (int i = 0; i < size - 1; i++) { //모든 요소
            System.out.println("패스"+(i+1)+":");

            for (int j = size - 1; j > i; j--) { // arr[4]=6, 4
                compareCnt++;

                for (int s = 0; s < arr.length; s++) {
                    if(j == s && arr[s] < arr[s-1]) System.out.print("+");
                    else if (j == s && arr[s] >= arr[s-1]) System.out.print("-");
                    else if (j != s) System.out.print(" ");
                    System.out.print(arr[s]); //1자리정수
                }
                System.out.println();

                if(arr[j] < arr[j-1]) {
                    swapCnt++;
                    swap(arr, j, j-1);
                }
            }

            for (int num : arr) {
                System.out.printf("%2d", num);//2자리정수
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("비교횟수 = " + compareCnt);
        System.out.println("교환횟수 = " + swapCnt);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순교환정렬(버블 정렬)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        forwardBubbleSortProcess(x, nx);				// 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
