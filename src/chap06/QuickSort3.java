package chap06;

import java.util.Scanner;

public class QuickSort3 {
    //Ex14
    static void qsort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    //Ex13
    static void quickSort(int[] arr, int left, int right) {
        //요솟수 9이하일 떄, 단순삽입 정렬
        if(right - left < 9) {
            insertionSort(arr, right+1);
            return;
        }

        int pl = left;
        int pr = right;
        int m = sort3elem(arr, pl, (pl+pr)/2, pr); //수3개(처음,중간,끝)만 정렬
        int pivot = arr[m]; //정렬후 가운데의 값
        swap(arr, m, right-1); //가운데 요소와 끝-1 요소 교환

        //커서 이동
        pl++;
        pr -= 2;

        do {
            while (pl < pivot) pl++;
            while (pr > pivot) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

       if (left < pr) quickSort(arr, left, pr);
       if (pl < right) quickSort(arr, pl, right);
    }

    /**
     * x[a], x[b], x[c]을 정렬(중앙값의 인덱스를 반환)
     * @param a < b < c
     */
    static int sort3elem(int[] x, int a, int b, int c) {
        if(x[b] < x[a]) swap(x, a, b);
        if(x[c] < x[b]) swap(x, b, c);
        if(x[b] < x[a]) swap(x, a, b);

        return b;
    }
    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1]; arr[idx1] = arr[idx2]; arr[idx2] = tmp;
    }

    static void insertionSort(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            int j;
            int target = arr[i]; //비교할 값

            for (j = i; j > 0 && arr[j-1] > target; j--) {
                arr[j] = arr[j-1];
            }

            arr[j] = target;
        }
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

        qsort(x, nx);			// 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
