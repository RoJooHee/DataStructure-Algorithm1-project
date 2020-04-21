import java.util.Scanner;

class ArrayQueue<E> {
	private E[] q;
	private int front, back, size; // 0,1,2.. front���� back�߰�

	public ArrayQueue() {
		q = (E[]) new Object[10000];
		front = back = size = 0; // front�� �� �� �������� �� �ε���. back�� �� ������ �������� �ε���
	}

	public void push(E X) { // ���� x�� ť�� ����
		back = (back + 1) % q.length; // (a+1)%q.length = a�� ���� ���� �ε���
		q[back] = X; // �ε��� �ϳ� �÷��� x�� ����
		size++;
	}

	public E pop() { // ���� �տ� �ִ� ���� ���� �� �� ���. ť�� �ƹ��͵� ������ -1
		front = (front + 1) % q.length; // front �ε��� �ϳ� �ڷ� �Űܼ�
		E item = q[front];
		q[front] = null;
		size--;
		return item;
	}

	public int size() { // ť�� ����ִ� ������ ����
		return size;
	}

	public E front() { // ť�� ���� ��(ó��)�� �ִ� ����. ť�� �ƹ��͵� ������ -1
		return q[front + 1];
	}

	public E back() { // ť�� ���� ��(��)�� �ִ� ����. ť�� �ƹ��͵� ������ -1
		return q[back];
	}

	public int empty() { // ť�� ��������� 1, �ƴϸ� 0
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
			String order = s.next(); // ����� order�� �޾Ƽ� switch������ ����
			switch (order) {
			case "push":
				String x = s.next(); // push�� ��� ������ ������ �ٷ� x �Է¹���
				queue.push(x); // push�� x �Բ� �Լ� ȣ��
				break;
			case "pop":
				if (queue.empty() == 1) // pop, front, back�� empty���¸� -1 ����ϰ� �������� ���� ����ó��X
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