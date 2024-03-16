import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;	
	static int n;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int now=1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			// 종료 조건
			if(n==0) break;
			
			arr = new int[n][n];
			int [][] result = new int[n][n];
			boolean [][] visited = new boolean[n][n];
			for(int idx=0; idx<n; idx++) {
				st = new StringTokenizer(br.readLine());
				for(int idx2=0; idx2<n; idx2++) {
					arr[idx][idx2] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int what[]: result) {
				Arrays.fill(what, Integer.MAX_VALUE);
			}
			
			PriorityQueue<node> pq =new PriorityQueue<>();
			pq.add(new node(0,0,arr[0][0]));
			visited[0][0]=true;
			while(!pq.isEmpty()) {
				node cur = pq.poll();
				int distance = cur.weight;
				if(distance > result[cur.x][cur.y])continue;
				for(int i=0; i<4; i++) {
					int ax = dx[i]+cur.x;
					int ay = dy[i]+cur.y;
					if(ax<0 || ay<0 || ax>=n|| ay>=n || visited[ax][ay]) continue;
					if(distance+arr[ax][ay] <result[ax][ay]){
						result[ax][ay] = distance+arr[ax][ay];
						pq.offer(new node(ax,ay,result[ax][ay]));
					}
				}
			}
			
			System.out.println("Problem "+now+": "+result[n-1][n-1]);
			now++;
			
		}
	}
	
	
	public static class node implements Comparable<node>{
		int x;
		int y;
		int weight;
		
		public node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	

}