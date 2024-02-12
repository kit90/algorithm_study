package chap06;

import java.util.Scanner;

public class InsertSort {
    static void insertSort(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            int j;
            int target = arr[i]; //비교할 값

            //정렬된 (앞부분)배열의 마지막 = j가 시작점.
            for (j = i; j > 0 && arr[j-1] > target; j--) {
                arr[j] = arr[j-1];
            }
            //j--해가며
            //j-1이 타겟보다 크면, j를 j-1로 바꿈 = j-1이 오른쪽으로 이동
            //j-1이 타겟보다 작으면 for문 끝남
            //j에 타겟 대입
            arr[j] = target;
        }
    }

    static void insertSortEx6(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            //배열 위 표시 출력
            int minIdx = i;
            for (int m = i; m < size; m++) {
                if(arr[minIdx] > arr[m]) minIdx = m;
            }

            for (int j = 0; j < size; j++) {
                if(i==j) System.out.printf("%2s", "*");
                else if (j==minIdx) System.out.printf("%2s", "+");
                else System.out.printf("  ");
            }
            System.out.println();

            //배열 출력
            for (int k = 0; k < size; k++) {
                System.out.printf("%2d", arr[k]);
            }
            System.out.println();

            //정렬(swap)
            int target = arr[minIdx];
            if(target < arr[i]) {
                arr[minIdx] = arr[i];
                arr[i] = target;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertSortEx6(x, nx);        // 배열 x를 단순삽입정렬

//        System.out.println("오름차순으로 정렬했습니다.");
//        for (int i = 0; i < nx; i++)
//            System.out.println("x[" + i + "]=" + x[i]);
    }
}
