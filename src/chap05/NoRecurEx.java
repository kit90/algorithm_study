package chap05;

import chap04.IntStack;

import java.util.Scanner;

class NoRecurEx {

    static void recur3(int n) {
        if(n>0) {
            recur3(n-1);
            recur3(n-2);
            System.out.print(n);
        }
    }

    static void noRecur3_1(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++; //(1)0 1 2 (2)2 (3)1
                nstk[ptr] = n; //(1)ns[0]=3 ns[1]=2 ns[2]=1 /(2)ns[2]=1 /(3)ns[1]=2
                sstk[ptr] = sw; //(1)ss[0]=0 ss[1]=0 ss[2]=0 /(2)ss[2]=1 /(3)ss[1]=

                if (sw == 0)
                    n = n - 1; //(1)n=2 n=1 n=0
                else if (sw == 1) { //(2)n=-1, sw=0
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n  = nstk[ptr]; //(1)n=ns[2]=1 /(2)n=ns[2]=1 n=ns[1]=2
                sw = sstk[ptr--] + 1; //(1)sw=ss[2]+1=1 /(2)sw=ss[2]+1=2 sw=ss[1]+1=1
                                        //(1)ptr=1 /ptr=1 ptr=0
                if (sw == 2) {
                    System.out.println(n); //(2)"1"
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur3(x);
        System.out.println();
        //noRecur3(x);
    }
}
