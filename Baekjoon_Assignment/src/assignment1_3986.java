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
		return data[top - 1]; // 맨위에 있는 데이터 반환
	}

	public boolean empty() {
		return top == 0;
	}
}

public class assignment1_3986 {
	public static void main(String[] args) {
		int count = 0; // 좋은단어 개수세는 count 선언
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int i = 0; i < N; i++) {
			Stack<String> stack = new Stack<String>(100000);

			String voca = s.next();
			int length = voca.length();

			for (int j = 0; j < length; j++) {
				if (stack.empty() == false) // 만약 stack이 비어있지 않고
					if (stack.top().equals(Character.toString(voca.charAt(j))))
						stack.pop(); // top과 현재 글자가 같다면 pop
					else {
						stack.push(Character.toString(voca.charAt(j))); // top과 현재 글자가 다르다면 push
					}

				else // 만약 stack이 비어있다면 push
					stack.push(Character.toString(voca.charAt(j)));
			}
			if (stack.empty() == true)
				count += 1; // stack이 최종적으로 empty가 되면 count1 증가
			else
				;
		}
		System.out.println(count); // 맨 마지막에 좋은단어 개수 출력
	}

}