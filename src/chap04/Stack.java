package chap04;

public class Stack<E> {
    private E[] stk;
    private int capacity;
    private int ptr;

    //--- 실행시 예외: 스택이 비어있음 ---//
    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() { }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public static class OverflowStackException extends RuntimeException {
        public OverflowStackException() { }
    }

    //--- 생성자(constructor) ---//
    public Stack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = (E[])new Object[capacity];   // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음
            capacity = 0;
        }
    }


    //--- 스택에 x를 푸시 ---//
    public E push(E x) throws Stack.OverflowStackException {
        if (ptr >= capacity)                                    // 스택이 가득 참
            throw new Stack.OverflowStackException();
        return stk[ptr++] = x;
    }


    //--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public E pop() throws Stack.EmptyStackException {
        if (ptr <= 0)                                          // 스택이 빔
            throw new Stack.EmptyStackException();
        return stk[--ptr];
    }


    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public E peek() throws Stack.EmptyStackException {
        if (ptr <= 0)                                        // 스택이 빔
            throw new Stack.EmptyStackException();
        return stk[ptr - 1];
    }

    //--- 스택을 비움 ---//
    public void clear() {
        ptr = 0;
    }

    //--- 다 x를 찾아 인덱스(없으면 –1)를 반환 ---//
    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--)     // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x)
                return i;         // 검색 성공
        return -1;                // 검색 실패
    }


    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size() {
        return ptr;
    }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        return ptr >= capacity;
    }

    //--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }


}



