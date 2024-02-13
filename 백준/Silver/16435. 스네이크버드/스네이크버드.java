import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int [] fruit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {fruit[i] = Integer.parseInt(st.nextToken());}
		
		Arrays.sort(fruit);
		
		for(int i=0; i<N; i++) {
			if (fruit[i]<=L) {
				L+=1;
			}
		}
			
		System.out.println(L);
		

	}

}