import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> q; 
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int idx = 0; idx<T; idx++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cost [] = new int[N+1];
			// DP Table
			int DP [] = new int [N+1];
			st = new StringTokenizer(br.readLine());
			// 걸리는 시간 입력
			for(int i=1; i<=N; i++)cost[i] = Integer.parseInt(st.nextToken());
			// 리스트 초기화
			List<Integer>[] list = new ArrayList[N+1];
			for(int i=0; i<=N; i++) list[i] = new ArrayList<>();
			// 차수 입력
			int degrees[] = new int[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				list[s1].add(s2);
				degrees[s2]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			q = new ArrayDeque<Integer>();
			for(int i=1; i<=N; i++) {
				if(degrees[i]==0) {
					q.add(i);
					DP[i] = cost[i];
				}
			}
			
			// DP 접근
			while (!q.isEmpty()) {
			    int current = q.poll();
			    for (int next : list[current]) {
			    	DP[next] = Math.max(DP[next], cost[next] + DP[current]);
			        if (--degrees[next] == 0) {
			            q.add(next);
			        }
			    }
			}
			//System.out.println(Arrays.toString(DP));
			System.out.println(DP[W]);
			
		}

	}

}