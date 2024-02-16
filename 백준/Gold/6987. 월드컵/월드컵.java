import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static int [][]table;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		table = new int[4][18];
		for(int i=0; i<4; i++) {
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j<18; j++) {
			table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<4; i++) {
			answer = 0;
			backtracking(0, 1, table[i]);
			sb.append(answer).append(" ");
		}
		System.out.println(sb);
		
	}
	
	public static void backtracking(int home, int away, int[] Stable) {
	    if (away == 6) {
	        backtracking(home + 1, home + 2, Stable);
	        return;
	    }

	    if (home > 4) {
	        boolean check = Arrays.stream(Stable).allMatch(e -> e == 0);
	        if (check) {
	            answer = 1;
	        }
	        return;
	    }
	    for (int i = 0 , j=2; i < 3; i++,j--) {
	            if (Stable[home * 3 + i] > 0 && Stable[away * 3 + j] > 0) {
	                Stable[home * 3 + i]--;
	                Stable[away * 3 + j]--;
	                backtracking(home, away + 1, Stable);
	                Stable[home * 3 + i]++;
	                Stable[away * 3 + j]++;
	            }
	        }
	    }
	


}