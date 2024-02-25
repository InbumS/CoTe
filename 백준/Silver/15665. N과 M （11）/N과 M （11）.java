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
	static  StringBuilder sb;
	public static void main(String[] args)throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		record = new int [m];
		//visited = new boolean[n];
		sunyul(0);
		System.out.println(sb);
	}
	
	static void sunyul(int idx) {
		if(idx == m) {
			for(int val: record)
			{	
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int compare =-1;
		for(int j=0; j<n; j++) {
			if(arr[j]!=compare) {
			record[idx] = arr[j];
			compare = arr[j];
			sunyul(idx+1);
			}
			
		}
		
	}
	
		
}