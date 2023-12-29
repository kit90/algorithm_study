public class IntArrayQue {
    private int[] que; //큐용 배열
    private int capacity; //큐 용량
    private int num; //현재 데이터 갯수-포인터

    //--- 실행시 예외: 스택이 비어있음 ---//
    public class EmptyIntArrayQueException extends RuntimeException {
        public EmptyIntArrayQueException() {
        }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowIntArrayStackException extends RuntimeException {
        public OverflowIntArrayStackException() {
        }
    }

    public IntArrayQue(int maxlen) {
        this.capacity = maxlen;
        try {
            this.que = new int[maxlen];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntArrayStackException {
        if (num >= capacity) throw new OverflowIntArrayStackException();
        else {
            que[num++] = x;
            return x;
        }
    }

    public int deque() throws EmptyIntArrayQueException {
        if (num <= 0) throw new EmptyIntArrayQueException();
        else {
            int dequeItem = que[0];
            for (int i = 0; i < num - 1; i++) {
                que[i] = que[i + 1];
            }
            num--;
            return dequeItem;
        }
    }

    public int peek() throws EmptyIntArrayQueException {
        if (num <= 0) throw new EmptyIntArrayQueException();
        else
            return que[0];
    }

    public void clear() {
        num = 0;
    }

    public int indexOf(int key) {
        for (int i = 0; i < num; i++) {
            if (que[i] == key) return i;
        }

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num == 0) System.out.println("큐가 비었습니다.");
        else
            for (int i = 0; i < num; i++) {
                System.out.println("que[i] = " + que[i]);
            }
    }


}
