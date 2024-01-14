package chap05;

import java.util.Scanner;

public class HanoiString {
    static String[] name = {"A기둥", "B기둥", "C기둥"};

    static void move(int no, int a, int c) {
        if(no>1) //바닥 원반을 제외한 그룹을 시작기둥에서 중간기둥으로 잠시 옮겨둔다.
            move(no-1, a, 6-a-c);

        //바닥의 원반(no)을 시작기둥에서 목표기둥으로 옮겼음을 나타낸다
        System.out.println("원반"+no+"을" + name[a-1] + "에서 " + name[c-1] + "으로 이동");

        if(no>1) //바닥의 원반을 제외한 그룹을 중간기둥에서 목표기둥으로 옮긴다.
            move(no-1, 6-a-c, c);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);   // 제1기둥에 쌓인 n 개를 제3기둥으로 이동
    }
}
