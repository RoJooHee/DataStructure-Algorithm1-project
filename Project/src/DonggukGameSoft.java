import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	
	public static int partition(int[] data, int s, int e) {
		int pivot = data[e]; //	������ �����͸� �Ǻ������� �����Ѵ�.
		int i=s, j=e-1;
		while(i<=j) {  //�����Ͱ� �ִٸ� ��� ����
			if(data[i]<pivot) i++;
			else {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
				j--; }
		}
		data[e]=data[i]; //pivot�����͸� ��Ƽ���� ��迡 �ֱ� ���ؼ� data[i]�� data[e]�� ��ȯ
		data[i]=pivot;
		return i; //pivot�� �ִ� ��ġ�� �迭 �ε����� ��ȯ�Ѵ�.
	}
	//	data[0..n-1]���� k��°�� ���� �����͸� ã�´�.
	public static int nth_element(int[] data, int n, int k) {
		return nth_element(data, 0, n-1, k);
	}
	//	data[s..e]���� k��°�� ���� �����͸� ã�´�.
	public static int nth_element(int[] data, int s, int e, int k) {
		int p = partition(data, s, e); //data[s..e]�� �Ǻ����� ���ؼ� �и��Ѵ�.
		
		if(k<=p-s) return nth_element(data, s, p-1, k); //k�� �Ǻ����� ���� �׷쿡 �����ִ� ���
		if(k==p-s+1) return data[p]; //k�� �Ǻ��� ���
		return nth_element(data, p+1, e, k-p+s-1); //k�� �Ǻ����� ū �׷쿡 �����ִ� ���
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
		
		System.out.println("�� ���� �ñ��ϽŰ���? : ");
		int a = s.nextInt();
		System.out.println("------�ۼ��ڵ� ����------");
		long r = System.currentTimeMillis();
		nth_element(data, n, n);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		if (a==1) System.out.println("1�� : "+ data[n-1]+" / ���̾Ƹ�� 2000��");
		else if (a==2) System.out.println("2�� : "+data[n-2]+" / ���̾Ƹ�� 1800��");
		else if (a==3) System.out.println("3�� : "+data[n-3]+" / ���̾Ƹ�� 1600��");
		else if (a==4) System.out.println("4�� : "+data[n-4]+" / ���̾Ƹ�� 1400��");
		else if (a==5) System.out.println("5�� : "+data[n-5]+" / ���̾Ƹ�� 1200��");
		else if (5<=a && a<=10) System.out.println(data[n-a]+" / ���̾Ƹ�� 1000��"); //6~10��
		else if (a<=n*0.1) System.out.println(data[n-a]+" / ���̾Ƹ�� 800��"); //11~����10%
		else if (a<=n*0.2) System.out.println(data[n-a]+" / ���̾Ƹ�� 600��"); //����10%~����20%
		else if (a<=n*0.3) System.out.println(data[n-a]+" / ���̾Ƹ�� 400��"); //����20%~����30%
		else System.out.println(data[n-a]+" / ���̾Ƹ�� 200��"); //������

		System.out.println("����1 : "+data[n-9999999]);
		System.out.println("����2 : "+data[n-10000000]);
		//������ n��°(����ū��)ã�� ���� �κи� �κ����� �Ǿ��ִ� ����
		//���� �Լ��ڵ带 �� �ʿ��� �κе�� �����ϰ� ������

		System.out.println("\n------�ڹ� �⺻����------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("1�� : "+t[n-1]);

	}

}
