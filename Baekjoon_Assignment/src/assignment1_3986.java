import java.util.Scanner;

class Stack<E> {
	private E data[];
	private int top;

	public Stack(int size) {
		data = (E[]) new Object[size];
		top = 0;
	}

	public void push(E newItem) {
		data[top] = newItem;
		top++;
	}

	public void pop() {
		if (top > 0) {
			top--;
			data[top] = null;
		}
	}
	
	public E top() {
		return data[top - 1]; // ������ �ִ� ������ ��ȯ
	}

	public boolean empty() {
		return top == 0;
	}
}

public class assignment1_3986 {
	public static void main(String[] args) {
		int count = 0; // �����ܾ� �������� count ����
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int i = 0; i < N; i++) {
			Stack<String> stack = new Stack<String>(100000);

			String voca = s.next();
			int length = voca.length();

			for (int j = 0; j < length; j++) {
				if (stack.empty() == false) // ���� stack�� ������� �ʰ�
					if (stack.top().equals(Character.toString(voca.charAt(j))))
						stack.pop(); // top�� ���� ���ڰ� ���ٸ� pop
					else {
						stack.push(Character.toString(voca.charAt(j))); // top�� ���� ���ڰ� �ٸ��ٸ� push
					}

				else // ���� stack�� ����ִٸ� push
					stack.push(Character.toString(voca.charAt(j)));
			}
			if (stack.empty() == true)
				count += 1; // stack�� ���������� empty�� �Ǹ� count1 ����
			else
				;
		}
		System.out.println(count); // �� �������� �����ܾ� ���� ���
	}

}