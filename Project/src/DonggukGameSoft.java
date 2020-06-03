import java.util.Arrays;
import java.util.Scanner;
public class DonggukGameSoft {
	
	public static int partition(int[] data, int s, int e) {
		int pivot = data[e]; //	마지막 데이터를 피봇값으로 설정한다.
		int i=s, j=e-1;
		while(i<=j) {  //데이터가 있다면 계속 진행
			if(data[i]<pivot) i++;
			else {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
				j--; }
		}
		data[e]=data[i]; //pivot데이터를 파티션한 경계에 넣기 위해서 data[i]와 data[e]와 교환
		data[i]=pivot;
		return i; //pivot이 있는 위치의 배열 인덱스를 반환한다.
	}
	//	data[0..n-1]에서 k번째로 작은 데이터를 찾는다.
	public static int nth_element(int[] data, int n, int k) {
		return nth_element(data, 0, n-1, k);
	}
	//	data[s..e]에서 k번째로 작은 데이터를 찾는다.
	public static int nth_element(int[] data, int s, int e, int k) {
		int p = partition(data, s, e); //data[s..e]를 피봇값에 의해서 분리한다.
		
		if(k<=p-s) return nth_element(data, s, p-1, k); //k가 피봇보다 작은 그룹에 속해있는 경우
		if(k==p-s+1) return data[p]; //k가 피봇인 경우
		return nth_element(data, p+1, e, k-p+s-1); //k가 피봇보다 큰 그룹에 속해있는 경우
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
		
		System.out.println("몇 등이 궁금하신가요? : ");
		int a = s.nextInt();
		System.out.println("------작성코드 정렬------");
		long r = System.currentTimeMillis();
		nth_element(data, n, n);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		if (a==1) System.out.println("1등 : "+ data[n-1]+" / 다이아몬드 2000개");
		else if (a==2) System.out.println("2등 : "+data[n-2]+" / 다이아몬드 1800개");
		else if (a==3) System.out.println("3등 : "+data[n-3]+" / 다이아몬드 1600개");
		else if (a==4) System.out.println("4등 : "+data[n-4]+" / 다이아몬드 1400개");
		else if (a==5) System.out.println("5등 : "+data[n-5]+" / 다이아몬드 1200개");
		else if (5<=a && a<=10) System.out.println(data[n-a]+" / 다이아몬드 1000개"); //6~10등
		else if (a<=n*0.1) System.out.println(data[n-a]+" / 다이아몬드 800개"); //11~상위10%
		else if (a<=n*0.2) System.out.println(data[n-a]+" / 다이아몬드 600개"); //상위10%~상위20%
		else if (a<=n*0.3) System.out.println(data[n-a]+" / 다이아몬드 400개"); //상위20%~상위30%
		else System.out.println(data[n-a]+" / 다이아몬드 200개"); //나머지

		System.out.println("예시1 : "+data[n-9999999]);
		System.out.println("예시2 : "+data[n-10000000]);
		//지금은 n번째(제일큰거)찾기 위한 부분만 부분정렬 되어있는 상태
		//위에 함수코드를 다 필요한 부분들로 정렬하게 만들자

		System.out.println("\n------자바 기본정렬------");
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		
		System.out.println("1등 : "+t[n-1]);

	}

}
