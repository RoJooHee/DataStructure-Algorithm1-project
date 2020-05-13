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

	public int Find(int s) { //s�� ��Ʈ��带 ã��
		if(set[s].getParent()==s) return s; //�ڱ� �ڽ��� ��Ʈ����� ��� �״�� s ����
		int r = Find(set[s].getParent()); //s�� �θ��带 ��� ã�� ���ȣ�� ����� ���� ���ǿ� �����ϸ� ��Ʈ����̹Ƿ� r�� ����
		set[s].setParent(r);  //s�� �θ��带 r�� ������(��ξ���)
		return r; }

	public void Union(int a, int b) { //a,b�� �������� ����
		int ra = Find(a); //a,b�� ��Ʈ���Ҹ� ���� ra,rb�� ����
		int rb = Find(b);
		if( set[ra].getRank() >= set[rb].getRank() ) { //ra�� ��ũ�� rb�� ��ũ���� ���ų� ũ��
			set[rb].setParent(ra); //rb�� �θ��带 ra�� ����
			set[ra].setRank(set[ra].getRank()+set[rb].getRank()); //ra�� ��ũ�� (ra�� ��ũ+rb�� ��ũ)
		}
		else { //ra�� ��ũ�� rb�� ��ũ���� ������
			set[ra].setParent(rb); //ra�� �θ��带 rb�� ����
			set[rb].setRank(set[ra].getRank()+set[rb].getRank()); //rb�� ��ũ�� (ra�� ��ũ+rb�� ��ũ)
		}
	}
}
public class BJ1976 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int N= s.nextInt(); //������ ��
		int M= s.nextInt(); //���� ��ȹ�� ���� ���õ��� ��. �� �� ���õ��� ��� ���õ���� ������踦 �����غ�����
		
		Node[] array = new Node[N]; //��带 ������ ���� N��ŭ ����� ���� �ϴ� �ڱ⸸ ����Ű����(�������X)
		for(int i=0; i<N; i++) {
			array[i] = new Node();
			array[i].setParent(i);
		}
		
		UnionFind set = new UnionFind(array);

		for(int i=0; i<N; i++) { //��� ���õ��� case �м�
			for(int j=0; j<N; j++) { // �� ���ø��� ��� ���ÿ��� ������� �˱�
				int connect = s.nextInt();
				if (connect==1) { set.Union(i, j); }
				else ;
			}
	}
		
		int[] plan = new int[M];
		for (int i=0; i<M; i++) { //���� ��ȹ�� ���� ���ü� ��ŭ ��ȹ �Է��ϵ���
			plan[i]=s.nextInt()-1; } //�ε����� 0,1,2..�ε� �׽�Ʈ���̽������� 1,2,3.. �Է��ؼ� -1 ����

		int error=0;
		for (int i=1; i<M; i++) {
			if (set.Find(plan[i]) !=set.Find(plan[i-1])) error=1; //���� �ѹ��̶� ��Ʈ��尡 �ٸ�(��������x) ���� error
			else ; }
		
		if (error==0) System.out.println("YES");
		else System.out.println("NO");
	}
}
