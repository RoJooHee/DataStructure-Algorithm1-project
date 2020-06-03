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
		System.out.print("사용자 수를 10000000 이상으로 입력하세요 : ");
		int n = s.nextInt();
		int[] data = new int[n];
		int[] t = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000);
			t[i] = data[i];}
		
		System.out.print("몇 등이 궁금하신가요? : ");
		int a = s.nextInt();
		
		System.out.println("------작성코드 정렬------");
		long r = System.currentTimeMillis();
		System.out.println(a+"등: "+nth_element(data, n, n+1-a)+"점");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		//지금은 범위별로 다 정렬하지 않고, 그냥 그 등수에 해당하는 값만을 찾아서 가져옴. nth_element
		//저게 아니고, 범위별로 필요한 만큼 다 정렬한 리스트를 얻으면, 거기에서 인덱스로만 찾아와야함
		//data[n+1-a] 0.3을 피봇으로 잡아서 정렬. 그 피봇뒤의 인덱스들이 0.3. 그 인덱스위치로 피봇 잡을수있나?
		//0.2, 0.1, a=10 각각 피봇으로 잡아서 정렬.
		//a=5 피봇으로 잡아서 정렬하고 그 뒷부분 순서대로 정렬
		
		System.out.println("\n------자바 기본정렬------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println(a+"등: "+t[n-a]+"점");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		if (a==1) System.out.println("\n => 다이아몬드 2000개");
		else if (a==2) System.out.println("\n => 다이아몬드 1800개");
		else if (a==3) System.out.println("\n => 다이아몬드 1600개");
		else if (a==4) System.out.println("\n => 다이아몬드 1400개");
		else if (a==5) System.out.println("\n => 다이아몬드 1200개");
		else if (5<=a && a<=10) System.out.println("\n => 다이아몬드 1000개"); //6~10등
		else if (a<=n*0.1) System.out.println("\n => 다이아몬드 800개"); //11~상위10%
		else if (a<=n*0.2) System.out.println("\n => 다이아몬드 600개"); //상위10%~상위20%
		else if (a<=n*0.3) System.out.println("\n => 다이아몬드 400개"); //상위20%~상위30%
		else System.out.println("\n => 다이아몬드 200개"); //나머지
	}

}
