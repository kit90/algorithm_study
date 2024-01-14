package chap04;

public class DoubleHeadIntStack {
    private int[] stk;           // 스택용 배열
    private int capacity;        // 스택 크기
    private int ptrA;             // A스택 포인터
    private int ptrB;             // B스택 포인터

    public enum AorB {StackA, StackB}

    //--- 생성자(constructor) ---//
    public DoubleHeadIntStack(int maxlen) {
        ptrA = 0;
        ptrB = maxlen - 1;

        capacity = maxlen;
        try {
            stk = new int[capacity];          // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음
            capacity = 0;
        }
    }

    //--- 실행시 예외: 스택이 비어있음 ---//
    public class EmptyDoubleHeadIntStackException extends RuntimeException {
        public EmptyDoubleHeadIntStackException() {
        }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowDoubleHeadIntStackException extends RuntimeException {
        public OverflowDoubleHeadIntStackException() {
        }
    }


    //--- 스택에 x를 푸시 ---//
    public int push(AorB stack, int x) throws IntStack.OverflowIntStackException {
        switch (stack) {
            case StackA:
                if (ptrA >= ptrB) throw new OverflowDoubleHeadIntStackException();//스택 가득 참
                else return stk[ptrA++] = x;
            case StackB:
                if (ptrB <= ptrA) throw new OverflowDoubleHeadIntStackException();//스택 가득 참
                else return stk[ptrB--] = x;
        }
        return 0;
    }

    //--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public int pop(AorB stack) throws EmptyDoubleHeadIntStackException {
        switch (stack) {
            case StackA:
                if (ptrA <= 0) throw new EmptyDoubleHeadIntStackException();
                else return stk[ptrA--];
            case StackB:
                if (ptrB >= capacity - 1) throw new EmptyDoubleHeadIntStackException();
                else return stk[ptrB++];
        }

        return 0;
    }

    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public int peek(AorB stack) throws EmptyDoubleHeadIntStackException {
        switch (stack) {
            case StackA:
                if (ptrA <= 0) throw new EmptyDoubleHeadIntStackException();
                else return stk[ptrA - 1];
            case StackB:
                if (ptrB >= capacity - 1) throw new EmptyDoubleHeadIntStackException();
                else return stk[ptrB + 1];
        }

        return 0;
    }

    //--- 스택을 비움 ---//
    public void clear(AorB stack) {
        switch (stack) {
            case StackA:
                ptrA = 0;
                break;
            case StackB:
                ptrB = capacity - 1;
                break;
        }
    }

    //--- 다 x를 찾아 인덱스(없으면 –1)를 반환 ---//
    public int indexOf(AorB stack, int x) {
        switch (stack) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--)     // 꼭대기 쪽부터 선형 검색
                    if (stk[i] == x)
                        return i;         // 검색 성공
                break;
            case StackB:
                for (int i = ptrB + 1; i <= capacity - 1; i++)     // 꼭대기 쪽부터 선형 검색
                    if (stk[i] == x)
                        return i;         // 검색 성공
                break;
        }

        return -1;                // 검색 실패
    }

    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size(AorB stack) {
        if (stack == AorB.StackA) return ptrA;
        else return capacity - 1 - ptrB;
    }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty(AorB stack) {
        boolean isEmpty = false;
        switch (stack) {
            case StackA:
                if (ptrA <= 0) isEmpty = true;
                break;
            case StackB:
                if (ptrB >= capacity -1) isEmpty = true;
                break;
        }
        return isEmpty;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull(AorB stack) {
        boolean isFull = false;
        switch (stack) {
            case StackA:
                if (ptrA >= ptrB) isFull = true;
                break;
            case StackB:
                if (ptrB <= ptrA) isFull = true;
                break;
        }

        return isFull;
    }

    //--- 스택 안의 모든 데이터를 바닥 → 꼭대기의 순서로 출력 ---//
    public void dump(AorB stack) {

        switch (stack) {
            case StackA:
                if(ptrA <= 0) System.out.println("스택A가 비어 있습니다.");
                for (int i = 0; i < ptrA; i++) {
                    System.out.print("["+i+"]: "+this.stk[i]+"  ");
                }
                break;
            case StackB:
                if(ptrB >= capacity-1) System.out.println("스택B가 비어 있습니다.");
                for (int i = capacity-1 ; i > ptrB; i--) {
                    System.out.print("["+i+"]: "+this.stk[i]);
                }
                break;
        }

    }

}
