package chap01;

public class SumWhile {
    public static void main(String[] args) {
        sumWhile(3);
        sumWhile(4);
    }

    public static void sumWhile(int n) {
        int sum = 0;
        int i = 0;

        while (i < n) {
            i++;
            sum += i;
        }
        System.out.println("1부터 " + n + "까지의 합은: " + sum);
        System.out.println("종료시 i값:" + i);
    }
}
