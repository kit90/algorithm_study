package chap06;

import java.util.Scanner;

public class CocktailSort {
    static void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void cocktailSort(int[] arr, int size) {
        int front = 0;
        int rear = arr.length-1;
        int last = rear;

        int passNum = 0;
        int swapCnt = 0;
        int compareCnt = 0;

        while (front < rear) {
            passNum++;

            if(passNum%2 == 1) { //홀수 패스
                for (int i = rear; i > front; i--) {
                    compareCnt++;
                    if(arr[i-1] > arr[i])  {
                        swap(arr, i-1, i);
                        last = i;
                        swapCnt++;
                    }
                }
                front = last;
            } else { //짝수 패스
                for (int j = front; j < rear; j++) {
                    compareCnt++;
                    if(arr[j] > arr[j+1]) {
                        swap(arr, j, j+1);
                        last = j;
                        swapCnt++;
                    }
                }
                rear = last;
            }
        }

        System.out.println("compareCnt = " + compareCnt);
        System.out.println("swapCnt = " + swapCnt);
    }

    //--- 양방향 버블 정렬(셰이커 정렬)---//
    static void shakerSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int last = right;

        int swapCnt = 0;
        int compareCnt = 0;
        //arr = [9, 1, 2, 3, 4]
        while (left < right){
            for (int j = right; j > left; j--){ // left=0, r=4 [j=4~1]
                compareCnt++;
                if (a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j; //last=1
                    swapCnt++;
                }
            }
            left = last; //left=1 [1, 9, 2, 3, 4]

            for (int j = left; j < right; j++){ //left=1, r=4 [j=1~3]
                compareCnt++;
                if (a[j] > a[j + 1]){
                    swapCnt++;
                    swap(a, j, j + 1);
                    last = j;
                }
            } //last=3 [1, 2, 3, 4, 9]
            right = last; //r=3 [1, 2, 3, 4, 9]
        }

        System.out.println("compareCnt = " + compareCnt);
        System.out.println("swapCnt = " + swapCnt);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양방향 버블 정렬(셰이커 정렬)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        cocktailSort(x, nx);				// 배열 x를 양방향 버블 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
