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
		record = new int [m];
		johab(0, 0);
	}
	
	static void johab(int start, int idx) {
		if(idx == m) {
			for(int i=0; i<m; i++)
			{
				System.out.print(record[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int compare =-1;
		for(int i=start; i<n; i++) {
			int what = arr[i];
			if(what == compare)continue;
			record[idx] = arr[i];
			compare = what;
			johab(i+1, idx+1);
		}
		
	}
	
		
}