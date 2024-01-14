package chap05;

import java.util.Scanner;
import java.util.Stack;

public class RecurMemoCount {
    static String[] memo;
    static int count = 0;

    static void recur(int n) {
        count++;

        if(memo[n+1] != null)
            System.out.print(memo[n+1]);
        else {
            if(n > 0) {
                recur(n-1);
                System.out.println(n);
                recur(n-2);
                memo[n+1] = memo[n]+n+"\n"+memo[n-1]; //상향식 분석할 때
            } else { //memo[0], memo[1] <- n=-1, n=0일 때뿐
                memo[n+1] = "";
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();
        memo = new String[x+2]; //배열 길이 0이하일때, NegativeArraySizeException
        recur(x);

        System.out.println();
        System.out.println("count = " + count);
    }
}
