import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean visited[];
	static int[] record;
	static int[] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		visited = new boolean[n+1];
		record = new int[m];
		print(0);
	}
	
	static void print(int idx) {
		if(idx==m) {
			for(int j=0; j<m; j++) {
				System.out.print(record[j]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
		    visited[i] = true;
		    record[idx] = arr[i-1];
		    print(idx+1);
		    visited[i] = false; 
			}
		}

		
	}
		
}