import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<N; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		boolean flag = false;
		flag = nextPermutation();
		
		if(flag) {
		for(int idx=0; idx<arr.length; idx++) {
			System.out.print(arr[idx]+" ");
		}
		}else {
			System.out.println(-1);
		}
		
		
	}
	
	public static boolean nextPermutation() {
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i])i--;
		if(i<=0) return false;
		int j = N-1;
		while(arr[i-1]>=arr[j] && j>i)j--;
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		int k = N-1;
		while(i<k) {
			int temp2 = arr[i];
			arr[i] = arr[k];
			arr[k] = temp2;
			i++; k--;			
		}
		return true;
		
		
		
	}
}