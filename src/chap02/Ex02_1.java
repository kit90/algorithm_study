import java.util.Arrays;

public class Ex02_1 {
    public static void main(String[] args) {
        int[] array1 = {2, 5, 6, 15, 8, 10, 55};
        int[] array2 = {3, 6, 10, 60, 20, 600, 80, 10, -1};

        Ex02_1.reverseArray(array1);
        System.out.println("reverse array1" + Arrays.toString(array1));
        Ex02_1.sumOf(array1);
        Ex02_1.DCopy(array1, array2);
        //Ex02.sCopy(array1, array2);
        System.out.println("array1에 array2copy" + Arrays.toString(array1));

        int[] array3 = {10, 50, 20, -10, 99, 2, 4};
        int[] array4 = {9, 4, 7, 39, 20, 40, -2, 0};
        Ex02_1.reverseSCopy(array3, array4);

        System.out.println("array3 = " + Arrays.toString(array3));
        System.out.println("array4 = " + Arrays.toString(array4));
    }

    static void reverseArray(int[] array) {
        int n = array.length;

        for (int i = 0; i < n/2; i++) {
            int temp = array[(n-1) - i];
            array[(n-1) - i] = array[i];
            array[i] = temp;
        }
    }

    static void sumOf(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println(sum);
    }

    static void DCopy(int[] array1, int[] array2) {
        array1 = new int[array2.length];
        for (int i = 0; i < array2.length; i++) {
            array1[i] = array2[i];
        }
        array1[array1.length-1] = -1000;
    }

    static void sCopy(int[] array1, int[] array2) {
        int totalCount = array1.length <= array2.length ? array1.length : array2.length;
        for (int i = 0; i < totalCount; i++) {
            array1[i] = array2[i];
        }
        array1[array1.length-1] = -1000;
    }

    static void reverseSCopy(int[] array1, int[] array2) {
        array1 = new int[array2.length];

        int lastIdx = array2.length-1;
        for (int i = 0; i < array2.length ; i++) {
            array1[i] = array2[lastIdx - i];
        }

        System.out.println(Arrays.toString(array1));
        array1[0] = 1111;
    }


}
