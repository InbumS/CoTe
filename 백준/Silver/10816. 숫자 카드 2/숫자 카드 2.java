import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<Integer, Integer> check = new HashMap<>(); 	 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int card = Integer.parseInt(st.nextToken());
			check.put(card, check.getOrDefault(card, 0)+1);
		}
		/////////////해시///////////a////////////
	
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
		    int find = Integer.parseInt(st.nextToken());
		    if (check.get(find) == null) {
		        sb.append(0).append(" ");
		    } else {
		        sb.append(check.get(find)).append(" ");
		    }
		}
		
		System.out.println(sb);
	}


}