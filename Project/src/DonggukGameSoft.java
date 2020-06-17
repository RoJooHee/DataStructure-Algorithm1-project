//pivot���� nth���� ã�� ��� ������� 30�ۼ�Ʈ �ش� ������ - �ʹ� ���� ???
import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {

	static void quicksort1(int[] data, int s, int e) {
		//	������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		if(e <= s) return;
		int p = partition(data, s, e);
		quicksort2(data, p+1, e-1); }
	
	static int partition(int[] data, int s, int e) {
		int pivot = data[e]; //�� ������ ���Ҹ� �������� ��´�.
		int i=s, j=e-1;
		while(i<=j) {
			if(pivot < data[i]) { //�������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[e] = data[i]; //�Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
		data[i] = pivot;
		for (int a = i+1; a <= e; a++) { //pivot�� ���Ƿ� ������ ���̹Ƿ� �ϳ��� �մ��� �� �� ����
			data[a-1] = data[a]; }
		return i; }

	static void quicksort2(int[] data, int s, int e) { //���pivot�� �������� ������(ū��)�� ������
		if(e <= s) return; //������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		int p = partition2(data, s, e);
		quicksort2(data, s, p-1);
		quicksort2(data, p+1, e);}
	
	static int partition2(int[] data, int f, int p) {
		int pivot = data[p]; //�� ������ ���Ҹ� �������� ��´�.
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) { //�������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i]; //�Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
		data[i] = pivot;
		return i; }	

	//	data[s..e]���� k��°�� ���� �����͸� ã�´�.
	static int nth_element(int[] data, int s, int e, int k) {
		int p = partition2(data, s, e); //data[s..e]�� �Ǻ����� ���ؼ� �и��Ѵ�.
		if(k<=p-s) return nth_element(data, s, p-1, k); //k�� �Ǻ����� ���� �׷쿡 �����ִ� ���
		if(k==p-s+1) return data[p];//k�� �Ǻ��� ���
		return nth_element(data, p+1, e, k-p+s-1); } //k�� �Ǻ����� ū �׷쿡 �����ִ� ���

	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("����� ���� 1,000,000 ~ 10,000,000 ���̷� �Է��ϼ��� : ");
		int n = s.nextInt();
		int[] data = new int[n + 1];
		int[] t = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000); //���������� �ݺ� ���� 1,000,000~10,000,000
			t[i] = data[i]; } //data�迭=t�迭 
		System.out.print("�� ���� �ñ��ϽŰ���? : ");
		int a = s.nextInt();
		
		long r = System.currentTimeMillis();
		int num = nth_element(data, 0, n-1, (n-1)/30+1);
		data[n]=num; //����30�ۿ� �ش��ϴ� ���ڸ� pivot���� ����ϵ��� �� �ڿ� ����
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("------�ۼ��ڵ� ����------");
		r = System.currentTimeMillis();
		quicksort1(data, 0, n);
		
		System.out.println(a+"��: "+data[n-a]+"��");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));

		
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
