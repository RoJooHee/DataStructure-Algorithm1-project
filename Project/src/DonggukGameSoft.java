import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	
	public static int partition(int[] data, int s, int e) {
		int pivot = data[e];
		int i=s, j=e-1;
		while(i<=j) {
			if(data[i]<pivot) i++;
			else {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
				j--; }
		}
		data[e]=data[i];
		data[i]=pivot;
		return i;
	}

	public static int nth_element(int[] data, int n, int k) {
		return nth_element(data, 0, n-1, k);
	}

	public static int nth_element(int[] data, int s, int e, int k) {
		int p = partition(data, s, e);
		
		if(k<=p-s) return nth_element(data, s, p-1, k);
		if(k==p-s+1) return data[p];
		return nth_element(data, p+1, e, k-p+s-1);
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("����� ���� 10000000 �̻����� �Է��ϼ��� : ");
		int n = s.nextInt();
		int[] data = new int[n];
		int[] t = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000);
			t[i] = data[i];}
		
		System.out.print("�� ���� �ñ��ϽŰ���? : ");
		int a = s.nextInt();
		
		System.out.println("------�ۼ��ڵ� ����------");
		long r = System.currentTimeMillis();
		System.out.println(a+"��: "+nth_element(data, n, n+1-a)+"��");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		//������ �������� �� �������� �ʰ�, �׳� �� ����� �ش��ϴ� ������ ã�Ƽ� ������. nth_element
		//���� �ƴϰ�, �������� �ʿ��� ��ŭ �� ������ ����Ʈ�� ������, �ű⿡�� �ε����θ� ã�ƿ;���
		//data[n+1-a] 0.3�� �Ǻ����� ��Ƽ� ����. �� �Ǻ����� �ε������� 0.3. �� �ε�����ġ�� �Ǻ� �������ֳ�?
		//0.2, 0.1, a=10 ���� �Ǻ����� ��Ƽ� ����.
		//a=5 �Ǻ����� ��Ƽ� �����ϰ� �� �޺κ� ������� ����
		
		System.out.println("\n------�ڹ� �⺻����------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println(a+"��: "+t[n-a]+"��");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		if (a==1) System.out.println("\n => ���̾Ƹ�� 2000��");
		else if (a==2) System.out.println("\n => ���̾Ƹ�� 1800��");
		else if (a==3) System.out.println("\n => ���̾Ƹ�� 1600��");
		else if (a==4) System.out.println("\n => ���̾Ƹ�� 1400��");
		else if (a==5) System.out.println("\n => ���̾Ƹ�� 1200��");
		else if (5<=a && a<=10) System.out.println("\n => ���̾Ƹ�� 1000��"); //6~10��
		else if (a<=n*0.1) System.out.println("\n => ���̾Ƹ�� 800��"); //11~����10%
		else if (a<=n*0.2) System.out.println("\n => ���̾Ƹ�� 600��"); //����10%~����20%
		else if (a<=n*0.3) System.out.println("\n => ���̾Ƹ�� 400��"); //����20%~����30%
		else System.out.println("\n => ���̾Ƹ�� 200��"); //������
	}

}
