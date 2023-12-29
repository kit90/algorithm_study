public class BinSearchX {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 7, 10, 13, 15, 60, 60, 60, 60, 100};
        int idx = binSearch(arr, arr.length, 60);
        System.out.println("idx = " + idx);
    }

    static int binSearch(int[] a, int n, int key) {
        int resultIdx = 0;

        int startIdx = 0;
        int endIdx = n-1;
        do {
             int centerIdx = (startIdx + endIdx) / 2;
             if(a[centerIdx] == key) {
                 resultIdx = centerIdx;
                 break;
             }
             else if(a[centerIdx] > key) endIdx = centerIdx - 1;
             else startIdx = centerIdx + 1;
        } while (endIdx > startIdx);

        System.out.println("resultIdx = " + resultIdx);

        for (int i = resultIdx - 1 ; i >= 0; i--) {
            if(a[i] != key) {
                resultIdx = i + 1;
                return resultIdx;
            }
        }

        return -1;
    }

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 요소를 이진검색 ---//
    static int binSearchX(int[] a, int n, int key) {
        int pl = 0;			// 검색 범위 맨앞의 인덱스
        int pr = n - 1;		// 　 〃    　맨끝의 인덱스

        do {
            int   pc = (pl + pr) / 2;	// 중앙요소의 인덱스
            if (a[pc] == key) {
                for ( ; pc > pl; pc--)	// key와 같은 맨앞의 요소를 검색합니다
                    if (a[pc - 1] < key)
                        break;
                return pc;							// 검색 성공
            } else if (a[pc] < key)
                pl = pc + 1;						// 검색 범위를 앞쪽 절반으로 좁힘
            else
                pr = pc - 1;						// 검색 범위를 뒤쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;									// 검색 실패
    }
}
