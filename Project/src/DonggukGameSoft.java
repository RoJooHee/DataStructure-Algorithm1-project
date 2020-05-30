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
			t[i] = data[i];
		}
		long r = System.currentTimeMillis();
		System.out.println("�ۼ� �˰��� 1���� ���� : "+ nth_element(data, n, n)+"�̴�.");
		System.out.println("2�� : "+data[n-2]);
		System.out.println("3�� : "+data[n-3]);
		System.out.println("4�� : "+data[n-4]);
		System.out.println("5�� : "+data[n-5]);
		System.out.println("����1 : "+data[n-9999999]);
		System.out.println("����2 : "+data[n-10000000]);
		//1,2,3,4,5 & 6~10 & 11~����10% & ~����20% & ~����30% & ~������
		//������ n��°(����ū��)ã�� ���� �κи� �κ����� �Ǿ��ִ� ����
		//���� �Լ��ڵ带 �� �ʿ��� �κе�� �����ϰ� ������
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println("�⺻����  1���� ���� : "+t[n-1]);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
	}

}
