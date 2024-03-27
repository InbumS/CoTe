import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	// DP 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int [] arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx<n; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		int [] DP = new int [n+1];
		
		for(int i=0; i< n; i++) {
			// 비교하기 위해 생성 변수
			int temp = 0;
			for(int j=0; j<i; j++) {
				if (arr[j] <arr[i])
					temp  = Math.max(temp, DP[j]);
			}
			
			DP[i] = temp+1;
			
		}
		// streams
		System.out.println(Arrays.stream(DP).max().getAsInt());
		
		

	}

}