//pivot값을 nth원소 찾기 방법 사용으로 30퍼센트 해당 값으로 - 너무 느림 ???
import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {

	static void quicksort1(int[] data, int s, int e) {
		//	정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		if(e <= s) return;
		int p = partition(data, s, e);
		quicksort2(data, p+1, e-1); }
	
	static int partition(int[] data, int s, int e) {
		int pivot = data[e]; //맨 마지막 원소를 피폿으로 잡는다.
		int i=s, j=e-1;
		while(i<=j) {
			if(pivot < data[i]) { //피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[e] = data[i]; //피봇과 i에 있는 값과 교환한다.
		data[i] = pivot;
		for (int a = i+1; a <= e; a++) { //pivot은 임의로 설정한 값이므로 하나씩 앞당기며 그 값 삭제
			data[a-1] = data[a]; }
		return i; }

	static void quicksort2(int[] data, int s, int e) { //평균pivot값 기준으로 오른쪽(큰값)만 정렬함
		if(e <= s) return; //정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		int p = partition2(data, s, e);
		quicksort2(data, s, p-1);
		quicksort2(data, p+1, e);}
	
	static int partition2(int[] data, int f, int p) {
		int pivot = data[p]; //맨 마지막 원소를 피폿으로 잡는다.
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) { //피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i]; //피봇과 i에 있는 값과 교환한다.
		data[i] = pivot;
		return i; }	

	//	data[s..e]에서 k번째로 작은 데이터를 찾는다.
	static int nth_element(int[] data, int s, int e, int k) {
		int p = partition2(data, s, e); //data[s..e]를 피봇값에 의해서 분리한다.
		if(k<=p-s) return nth_element(data, s, p-1, k); //k가 피봇보다 작은 그룹에 속해있는 경우
		if(k==p-s+1) return data[p];//k가 피봇인 경우
		return nth_element(data, p+1, e, k-p+s-1); } //k가 피봇보다 큰 그룹에 속해있는 경우

	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("사용자 수를 1,000,000 ~ 10,000,000 사이로 입력하세요 : ");
		int n = s.nextInt();
		int[] data = new int[n + 1];
		int[] t = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000); //랜덤데이터 반복 생성 1,000,000~10,000,000
			t[i] = data[i]; } //data배열=t배열 
		System.out.print("몇 등이 궁금하신가요? : ");
		int a = s.nextInt();
		
		long r = System.currentTimeMillis();
		int num = nth_element(data, 0, n-1, (n-1)/30+1);
		data[n]=num; //상위30퍼에 해당하는 숫자를 pivot으로 사용하도록 맨 뒤에 넣음
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("------작성코드 정렬------");
		r = System.currentTimeMillis();
		quicksort1(data, 0, n);
		
		System.out.println(a+"등: "+data[n-a]+"점");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));

		
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
