import java.util.Scanner;

public class SearchIdx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = sc.nextInt();

        int[] arr = new int[num];
        int currIdx = 0;
        for (int i = 0; i < num; i++) {
            System.out.print("요소: ");
            int no = sc.nextInt();
            arr[i] = no;
        }
        System.out.print("찾을 숫자들: ");
        int key = sc.nextInt();

        int[] idx = new int[num];
        int resultCount = searchIdx(arr, num, key, idx);
        System.out.println("resultCount = " + resultCount);
    }

    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int idxIndex = 0;
        for (int i = 0; i < n; i++) {
            if(key == a[i]) idx[idxIndex++] = i;
        }
        return idxIndex;
    }
}
