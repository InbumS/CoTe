import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		// 2칸이긴 하지만 3칸을 봐야한다.아무것도 없을 상태
		
		int [][]DP =new int[N+1][3];
		int result = 0;
		
		DP[1][0]=1;
		DP[1][1]=1;
		DP[1][2]=1;
		
		for(int i=2; i<=N; i++) {
			DP[i][0] = (DP[i-1][0]+DP[i-1][1]+DP[i-1][2])%9901;
			DP[i][1] = (DP[i-1][0]+DP[i-1][2])%9901;
			DP[i][2] = (DP[i-1][0]+DP[i-1][1])%9901;
		}
		
		result = (DP[N][0]+DP[N][1]+DP[N][2])%9901;
		System.out.println(result);
	}

}