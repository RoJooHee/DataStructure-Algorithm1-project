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

		public int Find(int s) { //��Ʈ��� ã��
			if(set[s].getParent()==s) return s; //s��  �θ��尡 s�̸� �ڱ��ڽ��� ��Ʈ����̹Ƿ� s ����
			int r = Find(set[s].getParent()); //s�� �θ��带 ���� Find ���ȣ�� �ؼ�, ���� ���� �����ϰ� �Ǵ� ��带 ��Ʈ��� r�� ����
			set[s].setParent(r); //s�� �θ��带 r�� ������(��ξ���)
			return r; }

		public void Union(int a, int b) { //������ �����
			int ra = Find(a); //a�� b�� ��Ʈ��带 ra, rb�� ����
			int rb = Find(b);
			if( set[ra].getRank() >= set[rb].getRank() ) { //ra�� ��ũ�� rb���� ũ�ų� ���� ��쿡
				set[rb].setParent(ra); //rb�� �θ��带 ra�� ��
				set[ra].setRank(set[ra].getRank()+set[rb].getRank()); //ra�� ��ũ�� (ra�� ��ũ+rb�� ��ũ)
			}
			else { //ra�� ��ũ�� rb���� ���� ���
				set[ra].setParent(rb);  //ra�� �θ��带 rb�� ��
				set[rb].setRank(set[ra].getRank()+set[rb].getRank()); //rb�� ��ũ�� (ra�� ��ũ+rb�� ��ũ)
			}}
	}

	public class BJ1717 {
		public static void main(String[] args) {
			Scanner s= new Scanner(System.in);
			int n=s.nextInt(); //������ ����(0~n���� n+1���� ����)
			int m=s.nextInt(); //��� �Է� Ƚ��
			
			Node[] array = new Node[n+1]; //����� ������  �� n+1��
			for(int i=0; i<n+1; i++) { //0~n���� �ݺ�
				array[i] = new Node(); //�� array[i]���� ���� �����ϰ�, ���� �ڽ��� �θ���� ����
				array[i].setParent(i);
			}
			
			UnionFind set = new UnionFind(array); //set�̶�� �̸��� array ����
			
			for (int i=0; i<m; i++) {
				String order=s.next(); //��� �̸� �Է�
				int a= s.nextInt();
				int b= s.nextInt();
				
				if(order.equals("0")) { //���� 0 �Է����� ���,
					set.Union(a, b);  // a�� b�� ������ ������
				}
				else if(order.equals("1")) { //���� 1 �Է����� ���,
					if(set.Find(a) == set.Find(b)) System.out.println("YES"); //a�� b�� ��Ʈ��尡 ���� ��� ���� ���տ� ���Ե� ���̹Ƿ� yes ���
					else System.out.println("NO"); //��Ʈ��尡 �ٸ��� �ٸ� ���տ� ���� ���̹Ƿ� no ���
				}
			}

		}
	}