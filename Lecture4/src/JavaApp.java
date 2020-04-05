//Stack class
class Stack<E> {
	private E data[];
	private int top;
	// 생성자
	public Stack(int size) {
		data = (E[]) new Object[size];
		top = 0; }

	// push
	public void push(E newItem) {
		data[top] = newItem;
		top++; } // =data[top++]=newItem;
	
	// pop
	public void pop() {
		if (top > 0)
			top--; }

	// top
	public E top() {
		return data[top - 1]; }

	// empty
	public boolean empty() {
		return top == 0; }
}

public class JavaApp {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(1000); // 생성자매개변수 사이즈
		stack.push("apple");
		stack.push("mango");
		stack.push("banana");
		System.out.println(stack.top());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty()); //비어있는지
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty());
	}
}