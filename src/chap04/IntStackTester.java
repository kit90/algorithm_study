package chap04;// int형 고정 길이 스택의 사용 예

import java.util.Scanner;

class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);    // 최대 64 개를 푸시할 수 있는 스택

        while (true) {
            System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(5)클리어 (6)인덱스 (7)용량 (8)사이즈 (9)비었는지 (10)꽉찼는지 (0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:                                // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:                                // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:                                // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:                                // 덤프
                    s.dump();
                    break;

                case 5:                                // 클리어
                    s.clear();
                    break;

                case 6:                                // 인덱스
                    System.out.print("찾을 요소: ");
                    int key = stdIn.nextInt();
                    int idx = s.indexOf(key);

                    if (idx < 0) System.out.println("찾는 요소가 없습니다.");
                    else System.out.println("인덱스: " + idx);
                    break;

                case 7:                                // 용량
                    int capacity = s.getCapacity();
                    System.out.println("capacity = " + capacity);
                    break;

                case 8:                                // 사이즈
                    int size = s.size();
                    System.out.println("size = " + size);
                    break;

                case 9:                                // 비었는지
                    boolean isEmpty = s.isEmpty();
                    System.out.println("isEmpty = " + isEmpty);
                    break;

                case 10:                                // 꽉찼는지
                    boolean isFull = s.isFull();
                    System.out.println("isFull = " + isFull);
                    break;

            }//switch
        }//while
    }//main

}
