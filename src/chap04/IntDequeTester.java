// 연습4-7
// int형 고정 길이 덱의 테스트 프로그램

import java.util.Scanner;

class IntDequeTester {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque s = new IntDeque(64);                // 최대 64개를 넣을 수 있는 큐

        while (true) {
            System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)맨앞에  인큐　(2)맨앞에서  디큐　(3)맨앞에서 피크\n" +
                    "(4)맨끝에  인큐　(5)맨끝에서  디큐　(6)맨끝에서 피크\n" +
                    "(7)앞에서부터 덤프　(8)뒤에서부터 덤프 (9)검색　(0) 종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x = 0, idx;

            switch (menu) {
                case 1:                                                // 맨앞에  인큐
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(IntDeque.ForR.FRONT, x);
                    } catch (IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:                                                // 맨앞에서  디큐
                    try {
                        x = s.deque(IntDeque.ForR.FRONT);
                        System.out.println(" 디큐한 데이터는 " + x + "입니다.");
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:                                                // 맨앞에서 피크
                    try {
                        x = s.peek(IntDeque.ForR.FRONT);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:                                                // 맨앞에  인큐
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(IntDeque.ForR.REAR, x);
                    } catch (IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 5:                                                // 맨앞에서  디큐
                    try {
                        x = s.deque(IntDeque.ForR.REAR);
                        System.out.println(" 디큐한 데이터는 " + x + "입니다.");
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 6:                                                // 맨앞에서 피크
                    try {
                        x = s.peek(IntDeque.ForR.REAR);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 7:                                                // 덤프
                    s.dump(IntDeque.ForR.FRONT);
                    break;

                case 8:                                                // 덤프
                    s.dump(IntDeque.ForR.REAR);
                    break;

                case 9:                                                // 검색
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    int n = s.search(x);
                    if (n != 0)
                        System.out.printf("%d번째 데이터로 인덱스%d의 위치에 저장되어 있습니다.\n", n, s.indexOf(x));
                    else
                        System.out.println("그 데이터는 등록되어 있지 않습니다.");
                    break;
            }
        }
    }
}

