package chap06;

import chap04.IntStack;

import java.util.Scanner;

public class QuickSortStack {
    //Ex11 & Ex12 요솟수가 적은 그룹부터 나누도록(많은 그룹부터 push)
    static void quickSortPrintAndShort(int[] arr, int leftIdx, int rightIdx) {
        IntStack lstack = new IntStack(rightIdx - leftIdx + 1);
        IntStack rstack = new IntStack(rightIdx - leftIdx + 1);

        lstack.push(leftIdx);
        rstack.push(rightIdx);
        System.out.printf("최초 푸쉬{%d, %d} \n", leftIdx, rightIdx);

        while (lstack.isEmpty() != true) {
            //스택에서 꺼냄
            int pl = leftIdx = lstack.pop(); //왼쪽 커서
            int pr = rightIdx = rstack.pop(); //오른쪽 커서
            System.out.printf("{%d, %d}을 분할 \n", pl, pr);
            int pivot = arr[(leftIdx + rightIdx) / 2]; //피벗(가운데 요소)

            do {
                while (arr[pl] < pivot) pl++; //left: pivot과 같거나 크면 멈춤
                while (arr[pr] > pivot) pr--; //right: pivot과 같거나 작으면 멈춤
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);

            System.out.println("----------");
            if (leftIdx < pr && pl < rightIdx) {
                if (pr - leftIdx > rightIdx - pl) {
                    lstack.push(leftIdx); rstack.push(pr);
                    System.out.printf("{%d, %d}을 푸쉬 \n", leftIdx, pr);
                    lstack.push(pl); rstack.push(rightIdx);
                    System.out.printf("{%d, %d}을 푸쉬 \n", pl, rightIdx);
                } else {
                    lstack.push(pl); rstack.push(rightIdx);
                    System.out.printf("{%d, %d}을 푸쉬 \n", pl, rightIdx);
                    lstack.push(leftIdx); rstack.push(pr);
                    System.out.printf("{%d, %d}을 푸쉬 \n", leftIdx, pr);
                }
                System.out.println("----------");
            }
            else if (leftIdx < pr && !(pl < rightIdx)) {
                lstack.push(leftIdx);
                rstack.push(pr);
                System.out.printf("{%d, %d}을 푸쉬 \n", leftIdx, pr);
                System.out.println("----------");
            }
            else if (pl < rightIdx && !(leftIdx < pr)) {
                lstack.push(pl);
                rstack.push(rightIdx);
                System.out.printf("{%d, %d}을 푸쉬 \n", pl, rightIdx);
                System.out.println("----------");
            }
        }
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

        quickSortPrintAndShort(x, 0, nx - 1);            // 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }

}
