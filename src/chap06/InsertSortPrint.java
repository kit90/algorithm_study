package chap06;

import java.util.Scanner;

public class InsertSortPrint {
    static void swap(int idx1, int idx2, int[] arr) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void insertSortEx7(int[] arr, int size) {
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2d", arr[j]);
            }
            System.out.println();

            int target = arr[i + 1]; //비교할 값

            //타겟보다 클때 ^ 찍고 ---- 가다가 타켓 인덱스에서 +
            int start = 0;
            boolean needSwap = false;
            for (int j = 0; j < i + 1; j++) {
                if (target < arr[j]) {
                    start = j;
                    needSwap = true;
                    break;
                }
            }

            if (!needSwap) {
                for (int k = 0; k < i + 1; k++) {
                    System.out.print("  ");
                }
                System.out.println(" +");
                continue;
            }

            for (int k = 0; k <= i + 1; k++) {
                if (k == start) System.out.print(" ^");
                else if (k == i + 1) System.out.print("-+");
                else if (k > start && k < i + 1) System.out.print("--");
                else System.out.print("  ");
            }
            System.out.println();

            int j;
            for (j = i+1; j > 0 && arr[j-1] > target; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = target;
        }
    }

    static void insertSortEx7_2(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2d", arr[j]);
            }
            System.out.println();

            int j;
            int target = arr[i];
            for (j = i; j > 0 && arr[j-1] > target; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = target;

            System.out.print("  ".repeat(j));
            System.out.print(i != j ? " ^" : " "); //모든 j-1보다 target이 크면 j == i
            System.out.print("-".repeat(i - j));
            System.out.println("+");
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순삽입정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertSortEx7_2(x, nx);            // 배열 x를 단순삽입정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
