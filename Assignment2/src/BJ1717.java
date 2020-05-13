import java.util.*;
import java.util.Scanner;

class Node{
	int parent;
	int rank;
	public Node() { rank=1; }
	public int getParent() { return parent; }
	public void setParent(int p) { parent = p; }
	public int getRank() { return rank; }
	public void setRank(int r) { rank = r; }	
}

class UnionFind{
	Node[] set;
	public UnionFind(Node[] a) {set=a;}

		public int Find(int s) { //루트노드 찾기
			if(set[s].getParent()==s) return s; //s의  부모노드가 s이면 자기자신이 루트노드이므로 s 리턴
			int r = Find(set[s].getParent()); //s의 부모노드를 따라서 Find 재귀호출 해서, 위의 조건 만족하게 되는 노드를 루트노드 r로 만듦
			set[s].setParent(r); //s의 부모노드를 r로 설정함(경로압축)
			return r; }

		public void Union(int a, int b) { //합집합 만들기
			int ra = Find(a); //a와 b의 루트노드를 ra, rb로 설정
			int rb = Find(b);
			if( set[ra].getRank() >= set[rb].getRank() ) { //ra의 랭크가 rb보다 크거나 같을 경우에
				set[rb].setParent(ra); //rb의 부모노드를 ra로 함
				set[ra].setRank(set[ra].getRank()+set[rb].getRank()); //ra의 랭크는 (ra의 랭크+rb의 랭크)
			}
			else { //ra의 랭크가 rb보다 작은 경우
				set[ra].setParent(rb);  //ra의 부모노드를 rb로 함
				set[rb].setRank(set[ra].getRank()+set[rb].getRank()); //rb의 랭크는 (ra의 랭크+rb의 랭크)
			}}
	}

	public class BJ1717 {
		public static void main(String[] args) {
			Scanner s= new Scanner(System.in);
			int n=s.nextInt(); //집합의 개수(0~n까지 n+1개의 집합)
			int m=s.nextInt(); //명령 입력 횟수
			
			Node[] array = new Node[n+1]; //노드의 개수는  총 n+1개
			for(int i=0; i<n+1; i++) { //0~n까지 반복
				array[i] = new Node(); //각 array[i]마다 노드로 생성하고, 각자 자신을 부모노드로 설정
				array[i].setParent(i);
			}
			
			UnionFind set = new UnionFind(array); //set이라는 이름의 array 생성
			
			for (int i=0; i<m; i++) {
				String order=s.next(); //명령 이름 입력
				int a= s.nextInt();
				int b= s.nextInt();
				
				if(order.equals("0")) { //만약 0 입력했을 경우,
					set.Union(a, b);  // a와 b를 합집합 연산함
				}
				else if(order.equals("1")) { //만약 1 입력했을 경우,
					if(set.Find(a) == set.Find(b)) System.out.println("YES"); //a와 b의 루트노드가 같은 경우 같은 집합에 포함된 것이므로 yes 출력
					else System.out.println("NO"); //루트노드가 다르면 다른 집합에 속한 것이므로 no 출력
				}
			}

		}
	}