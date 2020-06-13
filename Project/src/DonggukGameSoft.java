import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	
	static void quicksort1(int[] data, int f, int p) {
		if(p <= f) return; //정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		int s = partition1(data, f, p);
		quicksort2(data, s+1, p);} //처음 설정한 pivot보다 큰 수들만 정렬하면됨(상위 값을 정렬해야하므로)
	
	static int partition1(int[] data, int f, int p) {
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
		for (int a = i+1; a <= p; a++) { //pivot은 임의로 설정한 값이므로 하나씩 앞당기며 그 값 삭제
			data[a-1] = data[a]; }
		return i; }
	
	static void quicksort2(int[] data, int f, int p) { //평균pivot값 기준으로 왼쪽(작은값)만 정렬함
		if(p <= f) return; //정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		int s = partition2(data, f, p);
		quicksort2(data, f, s-1);
		quicksort2(data, s+1, p);}
	
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
	
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.print("사용자 수를 1,000,000 ~ 10,000,000 사이로 입력하세요 : ");
		int n = s.nextInt();
		int[] data = new int[n + 1];
		int[] t = new int[n];
		double sum = 0;
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000); //랜덤데이터 반복 생성 1,000,000~10,000,000
			t[i] = data[i]; //data배열=t배열
			sum = sum + (data[i] / 1000000.0); //숫자 크기가 커져서, 랜덤 시작숫자로 나누어서 랜덤데이터 모두 더함
		}
		
		int avg = (int)((sum / n) * 1000000.0); //다 더한 랜덤데이터의 평균 구하기
		System.out.println("평균값 : " + avg);	
		data[n] = avg; //평균값 정도면 중간 부분에 있을 것이기에, 맨 마지막에 배치에 pivot으로 사용하기
		
		//for(int i=0; i<data.length; i++) {
		//	if (avg==data[i]) {System.out.println(i+"번째");}}  여러번 테스트해봐도 평균값이면 중간부분. 30%밑으로 안내려감
		
		System.out.print("몇 등이 궁금하신가요? : ");
		int a = s.nextInt();
		
		System.out.println("------작성코드 정렬------");
		long r = System.currentTimeMillis();
		quicksort1(data, 0, n);
		
		for(int i=0; i<data.length-1; i++) { //data배열은 pivot만드려고 하나 크게 만들어놔서 -1하고 돌리기
			if (avg==data[i]) {System.out.println(i+"번째");}}
		System.out.println(a+"등: "+data[n-a]+"점");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("\n------자바 기본정렬------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		
		for(int i=0; i<t.length; i++) {
			if (avg==t[i]) {System.out.println(i+"번째");}}
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
