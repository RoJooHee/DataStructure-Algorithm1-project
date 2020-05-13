import java.util.*;
import java.util.Scanner;

class Node {
	int parent;
	int rank;
	public Node() { rank = 1; } 
	public int getParent() { return parent; }
	public void setParent(int p) { parent = p; }
	public int getRank() { return rank; }
	public void setRank(int r) { rank =r; }
}

class UnionFind {
	Node[] set;
	public UnionFind(Node[] a) { set = a; }

	public int Find(int s) { //s의 루트노드를 찾음
		if(set[s].getParent()==s) return s; //자기 자신이 루트노드인 경우 그대로 s 리턴
		int r = Find(set[s].getParent()); //s의 부모노드를 계속 찾는 재귀호출 계속해 위의 조건에 만족하면 루트노드이므로 r로 설정
		set[s].setParent(r);  //s의 부모노드를 r로 설정함(경로압축)
		return r; }

	public void Union(int a, int b) { //a,b의 합집합을 만듦
		int ra = Find(a); //a,b의 루트원소를 각각 ra,rb로 설정
		int rb = Find(b);
		if( set[ra].getRank() >= set[rb].getRank() ) { //ra의 랭크가 rb의 랭크보다 같거나 크면
			set[rb].setParent(ra); //rb의 부모노드를 ra로 설정
			set[ra].setRank(set[ra].getRank()+set[rb].getRank()); //ra의 랭크는 (ra의 랭크+rb의 랭크)
		}
		else { //ra의 랭크가 rb의 랭크보다 작으면
			set[ra].setParent(rb); //ra의 부모노드를 rb로 설정
			set[rb].setRank(set[ra].getRank()+set[rb].getRank()); //rb의 랭크는 (ra의 랭크+rb의 랭크)
		}
	}
}
public class BJ1976 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int N= s.nextInt(); //도시의 수
		int M= s.nextInt(); //여행 계획에 속한 도시들의 수. 즉 이 도시들은 모든 도시들과의 연결관계를 생각해봐야함
		
		Node[] array = new Node[N]; //노드를 도시의 개수 N만큼 만들고 각자 일단 자기만 가리키도록(연결관계X)
		for(int i=0; i<N; i++) {
			array[i] = new Node();
			array[i].setParent(i);
		}
		
		UnionFind set = new UnionFind(array);

		for(int i=0; i<N; i++) { //모든 도시들의 case 분석
			for(int j=0; j<N; j++) { // 각 도시마다 모든 도시와의 연결관계 알기
				int connect = s.nextInt();
				if (connect==1) { set.Union(i, j); }
				else ;
			}
	}
		
		int[] plan = new int[M];
		for (int i=0; i<M; i++) { //여행 계획에 속한 도시수 만큼 계획 입력하도록
			plan[i]=s.nextInt()-1; } //인덱스는 0,1,2..인데 테스트케이스에서는 1,2,3.. 입력해서 -1 해줌

		int error=0;
		for (int i=1; i<M; i++) {
			if (set.Find(plan[i]) !=set.Find(plan[i-1])) error=1; //만약 한번이라도 루트노드가 다른(같은집합x) 경우는 error
			else ; }
		
		if (error==0) System.out.println("YES");
		else System.out.println("NO");
	}
}
