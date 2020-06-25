//2017112676 교육학과 노주희
import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
 	//전체에서 pivot값 기준으로 오른쪽(큰값) 찾기
	static int quicksort1(int[] data, int f, int p, int num) { //num은 pivot으로 하고싶은 값
		data[p+1]=num; //num을 pivot으로 설정하도록 배열의 맨 마지막에 넣기
		int s = partition1(data, f, p+1); //num까지 포함하는 data배열에서 num이 pivot으로서 위치하는 인덱스
		return s;}
	
	static int partition1(int[] data, int f, int p) { //pivot값 임의설정 partition
		int pivot = data[p]; 
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) { //퀵정렬 수행
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i];
		data[i] = pivot;
		for (int a = i+1; a <= p; a++) { 
			data[a-1] = data[a]; } //pivot은 임의로(num)설정한 값이므로, pivot 다음의 data[] 원소들을 하나씩 앞당기며 삭제
		return i; } //num이 pivot으로 나누는 인덱스 반환
	
	//pivot값 기준으로 분리된 큰값 부분에 해당하여 퀵정렬 수행
	static void quicksort2(int[] data, int f, int p) {
		if(p <= f) return;
		int s = partition2(data, f, p); //data[]에서 pivot이 위치하는 인덱스
		quicksort2(data, f, s-1); //pivot의 인덱스를 기준으로 작은 쪽, 큰 쪽 다 퀵정렬 수행
		quicksort2(data, s+1, p);}
	
	static int partition2(int[] data, int f, int p) { //pivot값 원래 배열의 끝 partition
		int pivot = data[p];
		int i=f, j=p-1;
		while(i<=j) {
			if(pivot < data[i]) {  //퀵정렬 수행
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--; }
			else i++; }
		data[p] = data[i];
		data[i] = pivot;
		return i; } //pivot으로 나누는 인덱스 반환
	
	//선택정렬
	public static void selection(int[] data, int f, int p) {
		for(int i=f; i<=p;i++) {
			int select = i;
			for(int j=i+1;j<=p;j++) {
				if(data[select]>data[j]) select=j; }
			int t = data[i]; 
			data[i] = data[select];
			data[select] = t; }
		}
	
	//	data[s..e]에서 n-k+1번째로 큰 데이터 찾기
	static int nth_element(int[] data, int s, int e, int k) {
		int p = partition2(data, s, e); 
		if(k<=p-s) return nth_element(data, s, p-1, k);
		if(k==p-s+1) return data[p];
		else return nth_element(data, p+1, e, k-p+s-1); } 

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("사용자 수를 입력하세요 : ");
		int n = sc.nextInt();
		
		System.out.print("몇 등이 궁금하신가요? : ");
		int a = sc.nextInt();
		System.out.println("( "+(double)a/n*100+" %에 해당하는 등수 )");
		

		System.out.println("\n <<<무결성 테스트 >>>");
		int[] data = new int[n + 1];
		int[] data2 = new int[n + 1];
		int[] t = new int[n];
		double sum = 0;
		for(int i=0;i<n;i++) {
			data[i] = (int)((Math.random()*9000001)+1000000); //랜덤데이터 반복 생성 1,000,000~10,000,000
			data2[i] = data[i]; //data배열=data2배열
			t[i] = data[i]; //data배열=t배열
			sum = sum + (data[i] / 1000000.0); //숫자의 크기가 커져서, 랜덤 시작숫자로 나누어서 랜덤데이터 모두 더함
		}
		
		//for(int i=0; i<data.length; i++) {
		//	if (avg==data[i]) {System.out.println(i+"번째");}}  여러번 테스트해봐도 평균값이면 중간부분. 30%밑으로 안내려감
		
		int avg = (int)((sum / n) * 1000000.0); //다 더한 랜덤데이터의 평균 구하기
		
		//퀵정렬의 시간효율을 알아보기 위함
		System.out.println("\n------퀵정렬로만 작성한 정렬------"); //pivot은 평균값으로 한번 퀵정렬 후, 평균보다 큰 값(상위랭크)부분만 재귀적인 퀵정렬로 전부 정렬
		long r = System.currentTimeMillis();
		
		int p_avg = quicksort1(data, 0, n-1, avg); //평균을 pivot으로 했을 때 전체 퀵정렬 후 pivot의 인덱스
		quicksort2(data, p_avg, n-1); //평균값 중간 정도부터 부터 1등까지 재귀적 퀵정렬해서 전부 정렬
		
		System.out.println(a+"등: "+data[n-a]+"점");
		System.out.println("걸린 시간 : "+(System.currentTimeMillis()-r)/1000.0f+"초");
		System.out.printf("1~5등 : %d, %d, %d, %d, %d \n", data[n-1], data[n-2], data[n-3], data[n-4], data[n-5]);
		if (n%10==0) System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data[n-6], data[n-10], data[(int)(n*0.9)], data[(int)(n*0.8)], data[(int)(n*0.7)]);
		else System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data[n-6], data[n-10], data[(int)(n*0.9)+1], data[(int)(n*0.8)+1], data[(int)(n*0.7)+1]);
		
		
		//문제의 조건 충족(경계데이터)
		System.out.println("\n------구간 경계값으로 나눈 정렬------");//pivot은 평균값으로 한번 퀵정렬 후, 평균보다 큰 값에서 30%, 그보다 큰값에서 20%.. 차례로 경계데이터를 구하고 그 값으로 한번씩 퀵정렬
		r = System.currentTimeMillis();
		
		int p_avg2 = quicksort1(data2, 0, n-1, avg); //평균 해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		int num30=-1;
		if (n%10==0) num30 = nth_element(data2, 0, n-1, (int)(n*0.7)+1); //30%해당 값(경계데이터) //총 데이터 개수가 10으로 나뉘는 경우는 10%단위로 퍼센트 계산할 때 절사할 필요가 없어서 (int)변환후 +1해주지 않아도됨.
		else num30 = nth_element(data2, 0, n-1, (int)(n*0.7)+2); //+2한 이유(원래 위치는+1 & 소수점 절사해서 상위 -%의 경계 데이터 구하기위해 +1)
		int p_30=quicksort1(data2, p_avg2, n-1, num30); //30%해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		int num20=-1;
		if (n%10==0) num20 = nth_element(data2, 0, n-1, (int)(n*0.8)+1); //20%해당 값(경계데이터)
		else num20 = nth_element(data2, 0, n-1, (int)(n*0.8)+2);
		int p_20=quicksort1(data2, p_30, n-1, num20); //20%해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		int num10=-1;
		if (n%10==0) num10 = nth_element(data2, 0, n-1, (int)(n*0.9)+1);
		else num10 = nth_element(data2, 0, n-1, (int)(n*0.9)+2); //10%해당 값(경계데이터)
		int p_10=quicksort1(data2, p_20, n-1, num10); //10%해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		int num_10th =  nth_element(data2, 0, n-1, n-10+1); //상위 10등 해당 값
		int p_10th=quicksort1(data2, p_10, n-1, num_10th); //10등 해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		int num_6th =  nth_element(data2, 0, n-1, n-6+1); //상위 6등 해당 값
		int p_6th=quicksort1(data2, p_10th, n-1, num_6th); //6등 해당 값을 pivot으로 정렬했을 때의 pivot 인덱스
		
		selection(data2, p_6th, n-1); // 6등부터 1등까지는 전부 재귀호출을 줄이기위해 선택정렬
		
		System.out.println(a+"등: "+data2[n-a]+"점");
		System.out.println("걸린 시간 : "+(System.currentTimeMillis()-r)/1000.0f+"초");
		System.out.printf("1~5등 : %d, %d, %d, %d, %d \n", data2[n-1], data2[n-2], data2[n-3], data2[n-4], data2[n-5]);
		if (n%10==0) System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data2[n-6], data2[n-10], data2[(int)(n*0.9)], data2[(int)(n*0.8)], data2[(int)(n*0.7)]);
		else System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", data2[n-6], data2[n-10], data2[(int)(n*0.9)+1], data2[(int)(n*0.8)+1], data2[(int)(n*0.7)+1]);
			
		
		//기본 정렬
		System.out.println("\n------자바 기본정렬------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		
		System.out.println(a+"등: "+t[n-a]+"점");
		System.out.println("걸린 시간 : "+(System.currentTimeMillis()-r)/1000.0f+"초");
		System.out.printf("1~5등 : %d, %d, %d, %d, %d \n", t[n-1], t[n-2], t[n-3], t[n-4], t[n-5]);
		if (n%10==0) System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", t[n-6], t[n-10], t[(int)(n*0.9)], t[(int)(n*0.8)], t[(int)(n*0.7)]);
		else System.out.printf("6등 : %d, 10등 : %d,  10per : %d,  20per : %d,  30per : %d \n\n", t[n-6], t[n-10], t[(int)(n*0.9)+1], t[(int)(n*0.8)+1], t[(int)(n*0.7)+1]);
	
		
		for(int i=1; i<=5; i++) { //1~5등 값
			if (data[n-i]==t[n-i] && data2[n-i]==t[n-i]) {System.out.print("/  "+i+"번째 값 동일함  /");}
			else {System.out.print("/  "+i+"번째 값 다름  /");}
		}
		System.out.println();
		
		for(int i=6; i<=10; i++) { //6~10등 값
			if (data[n-i]==t[n-i] && data2[n-i]==t[n-i]) {System.out.print("/  "+i+"번째 값 동일함  /");}
			else {System.out.print("/  "+i+"번째 값 다름  /");}
		}
		System.out.println();
		
		for(int j=9; j>=1; j--) { //10~90% 값
			if (n%10==0) {
				if (data[(int)(n*j*0.1)]==t[(int)(n*j*0.1)] && data2[(int)(n*j*0.1)]==t[(int)(n*j*0.1)]) System.out.print("/  "+(10-j)*10+"% 값 동일함  /");
				else System.out.print("/  "+(10-j)*10+"% 값 다름  /");
			} else {
				if (data[(int)(n*j*0.1)+1]==t[(int)(n*j*0.1)+1] && data2[(int)(n*j*0.1)+1]==t[(int)(n*j*0.1)+1]) System.out.print("/  "+(10-j)*10+"% 값 동일함  /");
				else System.out.print("/  "+(10-j)*10+"% 값 다름  /");
			}
		}
		System.out.println();
		
		if(n%10==0) {
			int count = 0;
			for(int i=(int)(n*0.9)-1; i>(int)(n*0.8); i--) { //10~20%에 속하는 배열값
				if(data[i]<t[(int)(n*0.8)] || data[i]>t[(int)(n*0.9)]) {System.out.print(i); count++;} } //기본정렬의 10,20%경계값에서 벗어나는 것이 있는지
			System.out.println("\n기본정렬의 10,20% 경계값 범위에서 벗어나는  퀵정렬 10~20% 사이의 값의 개수 : "+count +"개");
			
			int count2 = 0;
			for(int i=(int)(n*0.9)-1; i>(int)(n*0.8); i--) { //10~20%에 속하는 배열값
				if(data2[i]<t[(int)(n*0.8)] || data2[i]>t[(int)(n*0.9)]) {System.out.print(i); count2++;} }  //기본정렬의 10,20%경계값에서 벗어나는 것이 있는지
			System.out.println("기본정렬의 10,20% 경계값 범위에서 벗어나는  구간경계값으로 나눈 정렬 10~20% 사이의 값 개수 : "+count2 +"개");
		}
		else {
			int count = 0;
			for(int i=(int)(n*0.9); i>(int)(n*0.8)+1; i--) { //10~20%에 속하는 배열값
				if(data[i]<t[(int)(n*0.8)+1] || data[i]>t[(int)(n*0.9)+1]) {System.out.print(i); count++;} } //기본정렬의 10,20%경계값에서 벗어나는 것이 있는지
			System.out.println("\n기본정렬의 10,20% 경계값 범위에서 벗어나는  퀵정렬 10~20% 사이의 값의 개수 : "+count +"개");
			
			int count2 = 0;
			for(int i=(int)(n*0.9); i>(int)(n*0.8)+1; i--) { //10~20%에 속하는 배열값
				if(data2[i]<t[(int)(n*0.8)+1] || data2[i]>t[(int)(n*0.9)+1]) {System.out.print(i); count2++;} }  //기본정렬의 10,20%경계값에서 벗어나는 것이 있는지
			System.out.println("기본정렬의 10,20% 경계값 범위에서 벗어나는  구간경계값으로 나눈 정렬 10~20% 사이의 값 개수 : "+count2 +"개");
		}
		
		if (a==1) System.out.println("\n => 다이아몬드 2000개");
		else if (a==2) System.out.println("\n => 다이아몬드 1800개");
		else if (a==3) System.out.println("\n => 다이아몬드 1600개");
		else if (a==4) System.out.println("\n => 다이아몬드 1400개");
		else if (a==5) System.out.println("\n => 다이아몬드 1200개");
		else if (6<=a && a<=10) System.out.println("\n => 다이아몬드 1000개"); //6~10등
		else if (a<=n*0.1) System.out.println("\n => 다이아몬드 800개"); //11~상위10%
		else if (a<=n*0.2) System.out.println("\n => 다이아몬드 600개"); //상위10%~상위20%
		else if (a<=n*0.3) System.out.println("\n => 다이아몬드 400개"); //상위20%~상위30%
		else System.out.println("\n => 다이아몬드 200개"); //나머지
	}
}