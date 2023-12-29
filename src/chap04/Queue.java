public class Queue<E> {
    private E[] que;
    private int capacity;
    private int num;
    private int front;
    private int rear;

    //--- 실행 시 예외 : 큐가 비어 있음 ---//
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
        }
    }

    //--- 실행 시 예외 : 큐가 가득 참 ---//
    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {
        }
    }

    public Queue(int capacity) {
        num = front = rear = 0;
        capacity = capacity;
        que = (E[]) new Object[capacity];
    }

    //넣을 빈공간을 가르키는 포인터 rear
    public E enque(E x) throws OverflowQueueException {
        if (num >= capacity) throw new OverflowQueueException();

        que[rear++] = x;
        num++;
        if (rear == capacity) rear = 0;

        return x;
    }

   //첫번째 요소(첫번쨰 이전 빈 공간x)를 가르키는 포인터 front
    public E deque() throws EmptyQueueException {
        if (num <= 0) throw new EmptyQueueException();

        E x = que[front++];
        num--;
        if(front == capacity) front = 0;

        return x;
    }

    //--- 큐에서 데이터를 피크(맨앞 데이터를 들여다봄 ) ---//
    public E peek() throws EmptyQueueException {
        if(num <= 0) throw new EmptyQueueException();
        return que[front];
    }

    //--- 큐를 비웁니다 ---//
    public void clear() {
        num = front = rear = 0;
    }

    //--- 큐에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다 ---//
    //1. 동등연산자는 Reference Type에 대해 참조주소값을 비교
    //2. equals() 메서드도 객체의 실제 데이터가 아닌 참조 값을 기반으로 두 객체를 비교 -> 두 객체가 동일한 참조 값을 가지면, true
    //단 String은 equals를 오버라이딩 했으므로, 문자열의 내용이같은지 비교
    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (front + i) % capacity;
            if(que[idx].equals(x)) return idx;
        }

        return -1;
    }

    /**
     * x를 검색하여 큐 안에서 논리적으로 몇번째에 있는가를 반환
     * 프런트에 있을 시 1
     * 검색 실패시 0
     */
    public int search(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (front + i) % capacity;
            if(que[idx].equals(x)) return i + 1;
        }
        return 0;
    }

    //--- 큐 안의 모든 데이터를 맨앞 → 맨끝의 순서로 출력 ---//
    //출력하려면 Object.toString()메서드 필수(참조주소값이 아닌 내용 출력하려면)
    public void dump() {
        for (int i = 0; i < num; i++) {
            int idx = (front + i) % capacity;
            System.out.println("que["+i+"]" + que[idx].toString());
        }
    }
}
