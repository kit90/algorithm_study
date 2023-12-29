package chap01;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Ex01.max4(1, 2, 3, 4) = " + Ex01.max4(1, 2, 3, 4));
        System.out.println("Ex01.max4(1, 2, 3, 4) = " + Ex01.max4(4, 3, 2, 1));
        System.out.println("Ex01.max4(1, 2, 3, 4) = " + Ex01.max4(1, 2, 4, 3));
        System.out.println("Ex01.max4(1, 2, 3, 4) = " + Ex01.max4(3, 4, 1, 2));

        System.out.println("Ex01.min4(1, 2, 3, 4) = " + Ex01.min4(1, 2, 3, 4));
        System.out.println("Ex01.min4(1, 2, 3, 4) = " + Ex01.min4(4, 3, 2, 1));
        System.out.println("Ex01.min4(1, 2, 3, 4) = " + Ex01.min4(1, 2, 4, 3));
        System.out.println("Ex01.min4(1, 2, 3, 4) = " + Ex01.min4(3, 4, 1, 2));

        System.out.println("Ex01.min3(1, 2, 3, 4) = " + Ex01.min3(1, 2, 3));
        System.out.println("Ex01.min3(1, 2, 3, 4) = " + Ex01.min3(2, 3, 1));
        System.out.println("Ex01.min3(1, 2, 3, 4) = " + Ex01.min3(3, 1, 2));
    }
}