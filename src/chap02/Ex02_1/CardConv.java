package Ex02_1;

import java.util.Scanner;

public class CardConv {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("변환하는 음이 아닌 정수: ");
        int decimal = stdIn.nextInt();
        System.out.print("어떤 진수로 변환할까요? (2~32): ");
        int number = stdIn.nextInt();

        char[] cno = new char[32];
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTVWXYZ";
        int remainder = decimal;
        int idx = 0;
        int no = remainder % number;
        System.out.print(number+"|");
        System.out.printf("%10d%n", decimal);
        System.out.println("  +---------");
        do {
            no = remainder % number;
            cno[idx++] = dchar.charAt(no);
            remainder /= number;
            System.out.print(number+"|");
            System.out.printf("%10d@", remainder);
            System.out.println(" ..." + no);
            System.out.println("  +---------");
        }
        while (remainder != 0);

        String result = "";
        for (int i = idx-1 ; i >= 0; i--) {
            result += cno[i];
        }
        System.out.print(number+"진수로 "+result+"입니다.");
    }

}
