import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[][] = new int[N][N];
		long[][][] DP = new long [3][N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}}
		
		// 0은 가로 1은 세로 2는 대각선으로 정의
		DP[0][0][1]=1;
		DP[1][1][0]=0;
		DP[2][1][1]=0;
		
		// Bottom - UP
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1)continue;
				
				//세로일때
				if(i>=1) {
					DP[1][i][j] = DP[1][i-1][j]+ DP[2][i-1][j];
				}
				
				// 가로일때
				if(j>=1) {
					DP[0][i][j] += DP[0][i][j - 1] + DP[2][i][j - 1];
					
				}
				
				// 대각선 일때
				if(i>=1 && j>=1 && arr[i-1][j]!=1 && arr[i][j-1]!=1) {
					 DP[2][i][j] += DP[0][i - 1][j - 1] + DP[1][i - 1][j - 1] + DP[2][i - 1][j - 1];
				}
				
			}
		}
		
		
		System.out.println(DP[0][N-1][N-1]+DP[1][N-1][N-1]+DP[2][N-1][N-1]);
		
	}

}