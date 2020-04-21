import java.util.Scanner;

class Stack<E>{
	private E data[];
	private int top;
	
	public Stack(int size) {
		data=(E[]) new Object[size];
		top=0;}

	public void push(E newItem) {
		data[top]=newItem;
		top++;}
	
	public void pop() {
		if (top>0) {
			top--;
			data[top] = null;
		}
	}
	
	public boolean empty() {
		return top==0;}
}

public class assignment1_9012 {
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int T=s.nextInt(); //�׽�Ʈ ���̽� ���� T
		
		for(int i=0; i<T; i++) { //������ �׽�Ʈ���̽����� �ݺ�
			Stack<Character> stack=new Stack<Character>(50); //stack ����
			boolean error=false;
			String ex = s.next(); //�׽�Ʈ���̽� ���� �Է��� ex
			int exlength = ex.length(); //�׽�Ʈ���̽��� ���� exlength�� ����
			
			//if(exlength < 2 || exlength > 50) {
			//	System.out.println("��ȣ�� 2�� �̻� 50�� ���Ϸ� �Է����ּ���.");
			//	break;
			//}
	
			for(int j=0; j<exlength; j++) { //�׽�Ʈ���̽� �� ���ڸ��� �ݺ�
				if (ex.charAt(j)=='(') { //���� (�� �ԷµǸ� ���ÿ� ( push�ϱ�
					stack.push('(');
				}
				
				else { //���� )�� �ԷµǾ��µ�
					if (stack.empty()) { //������ ��������� "no"���
						 error=true;
						 break;
					}
					else
						stack.pop(); //������ �Ⱥ�������� (�ִٴ� ������ ���� pop�ϱ�
				}
			}
			if (stack.empty() == true && error == false) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		s.close();
	}
}