package chap06;

import java.util.Scanner;

public class QuickSortRecur {

    //Ex12 요솟수가 적은 그룹부터 나누도록(많은 그룹부터 push)
    static void quickSortShort(int[] arr, int leftIdx, int rightIdx) {
        int pl = leftIdx;
        int pr = rightIdx;
        int pivot = arr[(leftIdx + rightIdx) / 2];

        do {
            while (pl < pivot) pl++;
            while (pr > pivot) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        //left~pr, pl~right
        if (leftIdx < pr && pl < rightIdx) {
            if (pr - leftIdx > rightIdx - pl) {
                quickSortShort(arr, leftIdx, pr);
                quickSortShort(arr, pl, rightIdx);
            } else {
                quickSortShort(arr, pl, rightIdx);
                quickSortShort(arr, leftIdx, pr);
            }
        }
        else if (leftIdx < pr) quickSortShort(arr, leftIdx, pr);
        else if (pl < rightIdx) quickSortShort(arr, pl, rightIdx);
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        quickSortShort(x, 0, nx - 1);            // 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
