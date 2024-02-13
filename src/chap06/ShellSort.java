package chap06;

import java.util.Scanner;

public class ShellSort {

    private static int shellSortV1(int[] arr, int size) {
        int moveCnt = 0;
        for (int h = size / 2; h > 0; h /= 2) {
            for (int i = h; i < size; i++) {
                int k;
                int target = arr[i];
                for (k = i - h; k >= 0 && arr[k] > target; k -= h) {
                    arr[k + h] = arr[k];
                    moveCnt++;
                }
                arr[k + h] = target;
                moveCnt++;
            }
        }
        return moveCnt;
    }

    private static int shellSortV2(int[] arr, int size) {
        int moveCnt = 0;

        int h = 1;
        while (h < size) {
            h = h * 3 + 1;
        }

        for (; h > 0; h /= 3) {
            for (int i = h; i < size; i++) {
                int k;
                int target = arr[i];
                for (k = i - h; k >= 0 && arr[k] > target; k -= h) {
                    arr[k + h] = arr[k];
                    moveCnt++;
                }
                arr[k + h] = target;
                moveCnt++;
            }
        }

        return moveCnt;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x1 = new int[nx];
        int[] x2 = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x1[i] = x2[i] = stdIn.nextInt();
        }

        int count1 = shellSortV1(x1, nx);        // 배열 x를 셸 정렬
        int count2 = shellSortV2(x2, nx);

        System.out.println("V1 오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x1[" + i + "]＝" + x1[i]);
        System.out.println("V1 요소의 이동 회수는 " + count1 + "회입니다.");

        System.out.println("-------------");
        System.out.println("V2 오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x2[" + i + "]＝" + x2[i]);
        System.out.println("V2 요소의 이동 회수는 " + count2 + "회입니다.");
    }
}
