package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = sc.nextInt();

        int[] arr = new int[num];

        System.out.println("오름차순으로 값 입력");
        System.out.print("arr[0]");
        arr[0] = sc.nextInt();
        for(int i = 1; i < num; i++) {
            do {
                System.out.print("arr["+i+"]: ");
                arr[i] = sc.nextInt();
            } while (arr[i] < arr[i-1]);
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = Arrays.binarySearch(arr, key);
        if(idx < 0) {
            System.out.println("해당 값인 요소가 없습니다.");
            idx += - (idx*2) - 1;
            System.out.println("삽입해야 할 인덱스는 " + idx +"입니다.");
        }
        else System.out.println("그 값은 arr["+idx+"]에 있습니다.");
    }
}
