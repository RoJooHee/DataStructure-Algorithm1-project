import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	
	static void quicksort1(int[] data, int f, int p) {
		if(p <= f) return; //������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		int s = partition1(data, f, p);
		quicksort2(data, s+1, p);} //ó�� ������ pivot���� ū ���鸸 �����ϸ��(���� ���� �����ؾ��ϹǷ�)
	
	static int partition1(int[] data, int f, int p) {
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
		for (int a = i+1; a <= p; a++) { //pivot�� ���Ƿ� ������ ���̹Ƿ� �ϳ��� �մ��� �� �� ����
			data[a-1] = data[a]; }
		return i; }
	
	static void quicksort2(int[] data, int f, int p) { //���pivot�� �������� ����(������)�� ������
		if(p <= f) return; //������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		int s = partition2(data, f, p);
		quicksort2(data, f, s-1);
		quicksort2(data, s+1, p);}
	
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
	
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("����� ���� 1,000,000 ~ 10,000,000 ���̷� �Է��ϼ��� : ");
		int n = s.nextInt();
		int[] data = new int[n + 1];
		int[] t = new int[n];
		double sum = 0;
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000); //���������� �ݺ� ���� 1,000,000~10,000,000
			t[i] = data[i]; //data�迭=t�迭
			sum = sum + (data[i] / 1000000.0); //���� ũ�Ⱑ Ŀ����, ���� ���ۼ��ڷ� ����� ���������� ��� ����
		}
		
		int avg = (int)((sum / n) * 1000000.0); //�� ���� ������������ ��� ���ϱ�
		System.out.println("��հ� : " + avg);	
		data[n] = avg; //��հ� ������ �߰� �κп� ���� ���̱⿡, �� �������� ��ġ�� pivot���� ����ϱ�
		
		//for(int i=0; i<data.length; i++) {
		//	if (avg==data[i]) {System.out.println(i+"��°");}}  ������ �׽�Ʈ�غ��� ��հ��̸� �߰��κ�. 30%������ �ȳ�����
		
		System.out.print("�� ���� �ñ��ϽŰ���? : ");
		int a = s.nextInt();
		
		System.out.println("------�ۼ��ڵ� ����------");
		long r = System.currentTimeMillis();
		quicksort1(data, 0, n);
		
		for(int i=0; i<data.length-1; i++) { //data�迭�� pivot������� �ϳ� ũ�� �������� -1�ϰ� ������
			if (avg==data[i]) {System.out.println(i+"��°");}}
		System.out.println(a+"��: "+data[n-a]+"��");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("\n------�ڹ� �⺻����------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		
		for(int i=0; i<t.length; i++) {
			if (avg==t[i]) {System.out.println(i+"��°");}}
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
