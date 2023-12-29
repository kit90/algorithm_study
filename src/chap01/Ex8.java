package chap01;

public class Ex8 {
    public static void main(String[] args) {
        sumof(1, 10);
        sumof(10, 1);
        sumof(10, 10);
    }

    static void sumof(int a, int b) {
        int sum = 0;
        int end = 0;
        int start = 0;

        if(a >= b) {
           start = b;
           end = a;
        } else if (a < b) {
            start = a;
            end = b;
        } 

        for(int i = start; i < end+1 ; i++) {
            sum += i;
        }
        System.out.println(a + " 와 " + b + "사이의 합계: " + sum);
    }
}
