import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());
		int dp[] = new int [num+2];
		int T[] = new int[num+1];
		int P[] = new int [num+1];
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=num; i>=1; i--) {
			int next = i+T[i];
			
			if(next > num+1)dp[i] = dp[i+1];
			else {
				dp[i] = Math.max(P[i]+dp[next], dp[i+1]);
			}
			
			
		}
		
		System.out.println(dp[1]);
		
	}

}