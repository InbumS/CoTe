import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N =0;
	static List<List<Integer>>value;
	static int[] people;
	static boolean[] isVisited;
	static int threshold = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N]; // 각 지역의 인구 수 저장 용
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)people[i] = Integer.parseInt(st.nextToken());
		value = new ArrayList<>();
		// init
		for(int i =0; i<N; i++)value.add(new ArrayList<Integer>());
		
		// 인접 구역 정보 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int neighbor = Integer.parseInt(st.nextToken());
			for(int j=0; j<neighbor; j++) {
				int number = Integer.parseInt(st.nextToken());
				value.get(i).add(number-1);
			}
		}
		
		isVisited = new boolean[N];
		subset(0,0);
		if(threshold == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(threshold);
			
	}
	
	
	static void subset(int depth, int select) {
		if(depth == N) {
			if(select>0 && select<N) {
				List<Integer>A = new ArrayList<Integer>();
				List<Integer>B = new ArrayList<Integer>();
				
				for(int idx= 0; idx<N; idx++) {
					if(isVisited[idx])A.add(idx);
					else B.add(idx);
					
				}
				boolean status1 = BFS(A);
				boolean status2 = BFS(B);
				
				if(status1 && status2) {
					int number = 0;
					for(int i=0; i<N; i++) {
						if(isVisited[i])number+=people[i];
						else number-=people[i];
						
					}
					// 최소 차이 구하기
					threshold = Math.min(threshold, Math.abs(number));			
				}
					
			}
			return;
		}
		
		isVisited[depth] = true;
		subset(depth+1, select+1);
		
		isVisited[depth] = false;
		subset(depth+1, select);
		
		
	}
	
	static boolean BFS(List<Integer> what) {
		Queue<Integer> q =new ArrayDeque<Integer>();
		boolean [] check = new boolean[N];
		int init = what.get(0);
		q.add(init);
		check[init]=true;
		int length =  what.size()-1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			// current 배열 안 요소들 탐색
			for(int idx =0; idx < value.get(cur).size(); idx++) {
				int target = value.get(cur).get(idx);
				if(what.contains(target) && !check[target]) {
					q.add(target);
					check[target] = true;
					length--;
				}
				
				
			}
			
		}	
		
		boolean answer = (length==0)? true:false;
		//System.out.println(answer);
		return answer;
	}

}