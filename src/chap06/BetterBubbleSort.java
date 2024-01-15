package chap06;

import java.util.Scanner;

public class BetterBubbleSort {
    static void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void bubbleSortProcess1(int[] arr, int size) {
        int swapCnt = 0;
        int compareCnt = 0;
        for (int i = 0; i < size - 1; i++) { //모든 요소
            int changeCnt = 0;
            System.out.println("패스" + (i + 1) + ":");
            for (int j = size - 1; j > i; j--) { // arr[4]=6, 4
                for (int s = 0; s < arr.length; s++) {
                    String b = (j != s) ? " " :
                            arr[s] < arr[s - 1] ? "+" : "-";
                    System.out.print(b);
                    System.out.printf("%2d", arr[s]);
                }
                System.out.println();

                compareCnt++;

                if (arr[j] < arr[j - 1]) {
                    swap(arr, j-1, j);
                    changeCnt++;
                    swapCnt++;
                }
            }

            if (changeCnt == 0) break;

            for (int num : arr) {
                System.out.printf("%3d", num);//3자리정수
            }
            System.out.println();
        }

        System.out.println("비교횟수 = " + compareCnt);
        System.out.println("교환횟수 = " + swapCnt);
    }

    static void bubbleSort2(int[] arr, int size) {
        int k = 0;
        while (k < size - 1) {
            int last = size - 1; //마지막으로 요소를 교환한 위치
            for (int i = size - 1 ; i > k ; i--) {
                if(arr[i-1]> arr[i])  {
                    swap(arr, i-1, i);
                    last = i;
                }
            }
            k = last; //다음 패스 때, 마지막으로 요소를 교환한 위치에서 비교를 끝내고, 더이상 비교하지 않음
        }
    }

    static void bubbleSortProcess2(int[] arr, int size) {
        int swapCnt = 0;
        int compareCnt = 0;
        int passNum = 0;

        int k = 0;
        while (k < size - 1) {
            passNum++;
            System.out.println("패스" + (passNum) + ":");

            int last = size - 1; //마지막으로 요소를 교환한 위치
            for (int i = size - 1 ; i > k ; i--) {
                compareCnt++;

                //출력
                for (int s = 0; s < arr.length; s++) {
                    String between = (i != s) ? " " :
                            arr[s-1] > arr[s] ? "+" : "-";
                    System.out.printf("%s %2d", between, arr[s]); //%c : 문자(character)
                }
                System.out.println();

                if(arr[i-1]> arr[i])  {
                    swap(arr, i-1, i);
                    swapCnt++;
                    last = i;
                }
            }

            for (int num : arr) {
                System.out.printf("%3d", num);
            }
            System.out.println();

            k = last;
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

        bubbleSortProcess2(x, nx);                // 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
