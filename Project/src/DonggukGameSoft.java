//���� ȿ���� ���� �ڵ�. ��հ��� pivot������ �������� ������
import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	//��ü���� pivot�� �������� ������(ū��)
	static int quicksort1(int[] data, int f, int p, int num) { //num�� pivot���� �ϰ���� ��
		data[p+1]=num; //num�� pivot���� �����ϵ��� �� �������� �α�
		int s = partition1(data, f, p+1); //pivot�� �ε���
		return s;}
	
	static int partition1(int[] data, int f, int p) { //pivot�� ���Ǽ��� partition
		int pivot = data[p]; 
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i];
		data[i] = pivot;
		for (int a = i+1; a <= p; a++) { //pivot�� ���Ƿ� ������ ���̹Ƿ� �ϳ��� �մ��� �� �� ����
			data[a-1] = data[a]; }
		return i; }
	
	static void quicksort2(int[] data, int f, int p) {
		if(p <= f) return;
		int s = partition2(data, f, p);
		quicksort2(data, f, s-1);
		quicksort2(data, s+1, p);}
	
	static int partition2(int[] data, int f, int p) { //pivot�� �����迭�� partition
		int pivot = data[p];
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i];
		data[i] = pivot;
		return i; }
	
	//	data[s..e]���� k��°�� ���� �����͸� ã�´�.
	static int nth_element(int[] data, int s, int e, int k) {
		int p = partition2(data, s, e); //data[s..e]�� �Ǻ����� ���ؼ� �и��Ѵ�.
		if(k<=p-s) return nth_element(data, s, p-1, k); //k�� �Ǻ����� ���� �׷쿡 �����ִ� ���
		if(k==p-s+1) return data[p];//k�� �Ǻ��� ���
		else return nth_element(data, p+1, e, k-p+s-1); } //k�� �Ǻ����� ū �׷쿡 �����ִ� ���

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("����� ���� 1,000,000 ~ 10,000,000 ���̷� �Է��ϼ��� : ");
		int n = sc.nextInt();
		
		System.out.print("�� ���� �ñ��ϽŰ���? : ");
		int a = sc.nextInt();
		System.out.println("( "+(double)a/n*100+" %�� �ش��ϴ� ��� )");
		
		for(int k=1; k<=3; k++) {
			System.out.println("\n <<<"+k+" ��° ���Ἲ �׽�Ʈ >>>");
			int[] data = new int[n + 1];
			int[] data2 = new int[n + 1];
			int[] t = new int[n];
			double sum = 0;
			for(int i=0;i<n;i++) {
				data[i] = (int)((Math.random()*9000001)+1000000); //���������� �ݺ� ���� 1,000,000~10,000,000
				data2[i] = data[i]; //data�迭=data2�迭
				t[i] = data[i]; //data�迭=t�迭
				sum = sum + (data[i] / 1000000.0); //���� ũ�Ⱑ Ŀ����, ���� ���ۼ��ڷ� ����� ���������� ��� ����
			}
			
			//for(int i=0; i<data.length; i++) {
			//	if (avg==data[i]) {System.out.println(i+"��°");}}  ������ �׽�Ʈ�غ��� ��հ��̸� �߰��κ�. 30%������ �ȳ�����
			int avg = (int)((sum / n) * 1000000.0); //�� ���� ������������ ��� ���ϱ�
			
			System.out.println("\n------ȿ�������� �ۼ��� ����------");
			long r = System.currentTimeMillis();
			
			int p_avg = quicksort1(data, 0, n-1, avg); //����� pivot���� ���� �� ��ü ������ �� pivot�� �ε���

			quicksort2(data, p_avg, n-1); //��հ� �߰� �������� ���� 1����� ����� �������ؼ� ���� ����
			
			System.out.println(a+"��: "+data[n-a]+"��");
			System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
			System.out.printf("1~5�� : %d, %d, %d, %d, %d \n", data[n-1], data[n-2], data[n-3], data[n-4], data[n-5]);
			System.out.printf("6�� : %d, 10�� : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data[n-6], data[n-10], data[(int)(n*0.9)+1], data[(int)(n*0.8)+1], data[(int)(n*0.7)+1]);
			System.out.println("10~20per ���� ���� : "+data[(int)(n*0.8)+2]+"  "+data[(int)(n*0.8)+10]);
			System.out.printf("���ľ���  60per : %d,  90per : %d \n", data[(int)(n*0.4)+1], data[(int)(n*0.1)+1]);
			
			
			System.out.println("\n------���� ��谪���� ���� ����------");
			r = System.currentTimeMillis();

			int p_avg2 = quicksort1(data2, 0, n-1, avg); //��� �ش� ���� pivot���� �������� ���� pivot �ε���
			
			double q30 = (double)(n*0.7); //��ü���� ���� 30%
			int num30 = nth_element(data2, 0, n-1, (int)(q30)+1); //30%�ش� ��
			int p_30=quicksort1(data2, p_avg2, n-1, num30); //30%�ش� ���� pivot���� �������� ���� pivot �ε���
			
			double q20 = (double)(n*0.8); //��ü���� ���� 20%
			int num20 = nth_element(data2, 0, n-1, (int)(q20)+1); //20%�ش� ��
			int p_20=quicksort1(data2, p_30, n-1, num20); //20%�ش� ���� pivot���� �������� ���� pivot �ε���
			
			double q10 = (double)(n*0.9); //��ü���� ���� 10%
			int num10 = nth_element(data2, 0, n-1, (int)(q10)+1); //10%�ش� ��
			int p_10=quicksort1(data2, p_20, n-1, num10); //10%�ش� ���� pivot���� �������� ���� pivot �ε���
			
			int num_10th =  nth_element(data2, 0, n-1, n-10+1);
			int p_10th=quicksort1(data2, p_10, n-1, num_10th); //10�� �ش� ���� pivot���� �������� ���� pivot �ε���
			
			int num_6th =  nth_element(data2, 0, n-1, n-6+1);
			int p_6th=quicksort1(data2, p_10th, n-1, num_6th); //10�� �ش� ���� pivot���� �������� ���� pivot �ε���
			
			quicksort2(data2, p_6th, n-1); //n���� ���ʿ��� �� �ֱ� ����
			
			System.out.println(a+"��: "+data2[n-a]+"��");
			System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
			System.out.printf("1~5�� : %d, %d, %d, %d, %d \n", data2[n-1], data2[n-2], data2[n-3], data2[n-4], data2[n-5]);
			System.out.printf("6�� : %d, 10�� : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data2[n-6], data2[n-10], data2[(int)(n*0.9)+1], data2[(int)(n*0.8)+1], data2[(int)(n*0.7)+1]);
			System.out.println("10~20per ���� ���� : "+data2[(int)(n*0.8)+2]+"  "+data2[(int)(n*0.8)+10]);
			System.out.printf("���ľ���  60per : %d,  90per : %d \n", data2[(int)(n*0.4)+1], data2[(int)(n*0.1)+1]);

			
			System.out.println("\n------�ڹ� �⺻����------");
			r = System.currentTimeMillis();
			Arrays.sort(t);
			
			System.out.println(a+"��: "+t[n-a]+"��");
			System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
			System.out.printf("1~5�� : %d, %d, %d, %d, %d \n", t[n-1], t[n-2], t[n-3], t[n-4], t[n-5]);
			System.out.printf("6�� : %d, 10�� : %d,  10per : %d,  20per : %d,  30per : %d \n\n", t[n-6], t[n-10], t[(int)(n*0.9)+1], t[(int)(n*0.8)+1], t[(int)(n*0.7)+1]);
			System.out.println("10~20per ���� ���� : "+t[(int)(n*0.8)+2]+"  "+t[(int)(n*0.8)+10]);
			System.out.printf("�⺻���ĵ�  60per : %d,  90per : %d \n\n", t[(int)(n*0.4)+1], t[(int)(n*0.1)+1]);
		
			
			for(int i=1; i<=5; i++) {
				if (data[n-i]==t[n-i] && data2[n-i]==t[n-i]) {System.out.print("/  "+i+"��° �� ������  /");}
				else {System.out.print("/  "+i+"��° �� �ٸ�  /");}
			}
			System.out.println();
			for(int j=9; j>=1; j--) {
				if (data[(int)(n*j*0.1)+1]==t[(int)(n*j*0.1)+1] && data2[(int)(n*j*0.1)+1]==t[(int)(n*j*0.1)+1]) {System.out.print("/  "+(10-j)*10+"% �� ������  /");}
				else {System.out.print("/  "+(10-j)*10+"% �� �ٸ�  /");}
			}
			System.out.println();
		}
		
		if (a==1) System.out.println("\n => ���̾Ƹ�� 2000��");
		else if (a==2) System.out.println("\n => ���̾Ƹ�� 1800��");
		else if (a==3) System.out.println("\n => ���̾Ƹ�� 1600��");
		else if (a==4) System.out.println("\n => ���̾Ƹ�� 1400��");
		else if (a==5) System.out.println("\n => ���̾Ƹ�� 1200��");
		else if (6<=a && a<=10) System.out.println("\n => ���̾Ƹ�� 1000��"); //6~10��
		else if (a<=n*0.1) System.out.println("\n => ���̾Ƹ�� 800��"); //11~����10%
		else if (a<=n*0.2) System.out.println("\n => ���̾Ƹ�� 600��"); //����10%~����20%
		else if (a<=n*0.3) System.out.println("\n => ���̾Ƹ�� 400��"); //����20%~����30%
		else System.out.println("\n => ���̾Ƹ�� 200��"); //������
	}
}