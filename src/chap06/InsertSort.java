package chap06;

public class InsertSort {
    static void insertSort(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            int j;
            int target = arr[i]; //비교할 값

            //정렬된 (앞부분)배열의 마지막 = j가 시작점.
            for (j = i; j > 0 && arr[j-1] > target; j--) {
                arr[j] = arr[j-1];
            }
            //j--해가며 j-1이 타겟보다 크면, j를 j-1로 바꿈
            //j-1이 타겟보다 작으면 for문 끝남
            //j에 타겟 대입
            arr[j] = target;
        }
    }
}
