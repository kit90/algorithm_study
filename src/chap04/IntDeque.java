// 연습4-5
// int형 고정 길이 큐(메서드 search를 추가)

/**
 * 링 버퍼(ring buffer) 자료구조
 */
public class IntDeque {
	private int[] que;			// 큐용 배열
	private int capacity;		// 큐의 용량
	private int front;			// 맨앞 요소 커서
	private int rear;				// 맨끝 요소 커서
	private int num;				// 현재 데이터 개수

	enum ForR {
		FRONT,
		REAR
	}

	//--- 실행 시 예외 : 큐가 비어 있음 ---//
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() { }
	}

	//--- 실행 시 예외 : 큐가 가득 참 ---//
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() { }
	}

	//--- 생성자 ---//
	public IntDeque(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];				// 큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {		// 생성할 수 없음
			capacity = 0;
		}
	}

	//--- 큐에 데이터를  인큐 ---//
	public int enque(ForR where, int x) throws OverflowIntDequeException {
		if (num >= capacity)
			throw new OverflowIntDequeException();			// 큐가 가득 참

		num++;
		switch (where) {
			case FRONT:
				if(--front < 0) front = capacity-1;
				que[front] = x;
				break;

			case REAR:
				que[rear++] = x;
				if (rear >= capacity) rear = 0;
				break;
		}

		return x;
	}

	//--- 큐에서 데이터를  디큐 ---//
	public int deque(ForR where) throws EmptyIntDequeException {
		if (num <= 0) throw new EmptyIntDequeException();			// 큐가 비어 있음
		int x = 0;

		num--;
		switch (where) {
			case FRONT:
				x = que[front++];
				if(front >= capacity) front = 0;
				break;

			case REAR:
				if (rear <= 0) rear = capacity;
				x = que[--rear];
				break;
		}

		return x;
	}

	//--- 큐에서 데이터를 피크(맨앞 데이터를 들여다봄 ) ---//
	public int peek(ForR where) throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();			// 큐가 비어 있음

		int x = 0;
		switch (where) {
			case FRONT:
				x = que[front];
				break;

			case REAR:
				if(rear <= 0) x = que[capacity-1];
				else x = que[rear-1];
				break;
		}

		return x;
	}

	//--- 큐를 비웁니다 ---//
	public void clear() {
		num = front = rear = 0;
	}

	//--- 큐 안의 모든 데이터를 맨앞 → 맨끝의 순서로 출력 ---//
	public void dump(ForR start) {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			switch (start) {
				case FRONT:
					for (int i = 0; i < num; i++)
						System.out.print(que[(i + front) % capacity] + " ");
					break;

				case REAR:
					for (int i = num-1; i >= 0; i--)
						System.out.print(que[(i + front) % capacity] + " ");
					break;
			}
		}
	}

	//--- 큐에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다 ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x)				// 검색 성공
				return idx;
		}
		return -1;							// 검색 실패
	}

	/**
	 * x를 검색하여 큐 안에서 논리적으로 몇번째에 있는가를 반환
	 * 프런트에 있을 시 1
	 * 검색 실패시 0
	 */
	public int search(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x)				// 검색 성공
				return i+1;
		}
		return 0;							// 검색 실패
	}

	//--- 큐의 용량을 반환합니다 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 큐에 쌓여있는 데이터수를 반환합니다 ---//
	public int size() {
		return num;
	}

	//--- 큐가 비어 있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}





}
