import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		int [] arr = new int[N];
		for(int idx = 0; idx<N; idx++) {
			arr[idx] = Integer.parseInt(br.readLine());
		}
		// 어떻게 접근할까? 우선 정렬은 맞다
		Arrays.sort(arr);
		// -1부터 1까지의 처리, 그리고 -1이 짝수일때는 큰 값대로 곱 하는게 나을듯?
		int idx = 0;
		while(idx < N && arr[idx] < 1) { 
				if(idx+1 < N && arr[idx+1]<1) {
					total += arr[idx]*arr[idx+1];
					idx+=2;
				}
				else {
					total+=arr[idx];
					idx++;
				}
				
		}
		
		int idx_p= N-1;
		while(idx_p >= idx && arr[idx_p] > 0) {
			if(idx_p -1 >= idx && arr[idx_p -1] > 1) { // 1이랑 곱하면 1은 그냥 버리는거다.
				total += arr[idx_p]*arr[idx_p-1];
				idx_p-=2;
			}
			else {
				total+=arr[idx_p];
				idx_p--;
			}
			
		}
		
		System.out.println(total);
		
		
		
	}

}