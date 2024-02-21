import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	static int S;
	static int [] sequence;
	static boolean [] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		sequence = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sequence);
		backTracking(0, 0);
		// 공집합 고려
		if(S==0) {
			System.out.println(cnt-1);
			return;
		}
		System.out.println(cnt);
		
	}
	
	
	
	static void backTracking(int x, int depth) {
		if(depth == sequence.length) {
			if(x==S) cnt++;
			return;
		}
		backTracking(x+sequence[depth], depth+1);
		backTracking(x, depth+1);
	}

}