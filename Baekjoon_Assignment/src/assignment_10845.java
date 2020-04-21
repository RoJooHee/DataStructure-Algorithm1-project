import java.util.Scanner;

class ArrayQueue<E> {
	private E[] q;
	private int front, back, size; // 0,1,2.. front삭제 back추가

	public ArrayQueue() {
		q = (E[]) new Object[10000];
		front = back = size = 0; // front는 맨 앞 데이터의 앞 인덱스. back은 맨 마지막 데이터의 인덱스
	}

	public void push(E X) { // 정수 x를 큐에 넣음
		back = (back + 1) % q.length; // (a+1)%q.length = a의 다음 원소 인덱스
		q[back] = X; // 인덱스 하나 늘려서 x를 넣음
		size++;
	}

	public E pop() { // 가장 앞에 있는 정수 빼고 그 수 출력. 큐에 아무것도 없으면 -1
		front = (front + 1) % q.length; // front 인덱스 하나 뒤로 옮겨서
		E item = q[front];
		q[front] = null;
		size--;
		return item;
	}

	public int size() { // 큐에 들어있는 정수의 개수
		return size;
	}

	public E front() { // 큐의 가장 앞(처음)에 있는 정수. 큐에 아무것도 없으면 -1
		return q[front + 1];
	}

	public E back() { // 큐의 가장 뒤(끝)에 있는 정수. 큐에 아무것도 없으면 -1
		return q[back];
	}

	public int empty() { // 큐가 비어있으면 1, 아니면 0
		if (size == 0)
			return 1;
		else
			return 0;
	}
}

public class assignment_10845 {
	public static void main(String[] args) throws Exception {
		ArrayQueue<String> queue = new ArrayQueue<String>();
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int i = 0; i < N; i++) {
			String order = s.next(); // 명령을 order로 받아서 switch문으로 돌림
			switch (order) {
			case "push":
				String x = s.next(); // push인 경우 무엇을 넣을지 바로 x 입력받음
				queue.push(x); // push와 x 함께 함수 호출
				break;
			case "pop":
				if (queue.empty() == 1) // pop, front, back은 empty상태면 -1 출력하고 끝나게해 따로 예외처리X
					System.out.println(-1);
				else
					System.out.println(queue.pop());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "front":
				if (queue.empty() == 1)
					System.out.println(-1);
				else
					System.out.println(queue.front());
				break;
			case "back":
				if (queue.empty() == 1)
					System.out.println(-1);
				else
					System.out.println(queue.back());
				break;
			case "empty":
				System.out.println(queue.empty());
				break;
			}
		}
		s.close();
	}
}