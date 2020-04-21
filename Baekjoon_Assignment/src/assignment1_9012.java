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
		int T=s.nextInt(); //테스트 케이스 개수 T
		
		for(int i=0; i<T; i++) { //각각의 테스트케이스마다 반복
			Stack<Character> stack=new Stack<Character>(50); //stack 생성
			boolean error=false;
			String ex = s.next(); //테스트케이스 각각 입력함 ex
			int exlength = ex.length(); //테스트케이스의 길이 exlength로 선언
			
			//if(exlength < 2 || exlength > 50) {
			//	System.out.println("괄호를 2개 이상 50개 이하로 입력해주세요.");
			//	break;
			//}
	
			for(int j=0; j<exlength; j++) { //테스트케이스 각 글자마자 반복
				if (ex.charAt(j)=='(') { //만약 (가 입력되면 스택에 ( push하기
					stack.push('(');
				}
				
				else { //만약 )가 입력되었는데
					if (stack.empty()) { //스택이 비어있으면 "no"출력
						 error=true;
						 break;
					}
					else
						stack.pop(); //스택이 안비어있으면 (있다는 뜻으로 스택 pop하기
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