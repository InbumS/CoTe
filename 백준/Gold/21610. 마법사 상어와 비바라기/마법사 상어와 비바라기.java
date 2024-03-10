import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] basket;
	static int N;
	static int dx []  = {0, -1,-1,-1,0,1,1, 1};
	static int dy []  = {-1,-1, 0, 1,1,1,0,-1};
	static Queue<cloud> q;
	static boolean [][] isVisited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<cloud>();
		int M = Integer.parseInt(st.nextToken());
		basket = new int[N][N];
		for(int idx= 0; idx<N; idx++) {
			st = new StringTokenizer(br.readLine());
			for(int idx2=0; idx2<N; idx2++){
				basket[idx][idx2] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new cloud(N-1,0));
		q.add(new cloud(N-1,1));
		q.add(new cloud(N-2,0));
		q.add(new cloud(N-2,1));
		isVisited = new boolean[N][N];

		//입력 받기
		for(int idx=0; idx<M; idx++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			// 움직이기
			isVisited = new boolean[N][N];
			move(d, s);
			
			
			
		}
		
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				total+=basket[i][j];
		}
		System.out.println(total);
		
	}
	
	static void move(int d, int s) {
		for(cloud c: q) {
			//System.out.println(sequence[i][0]+":"+sequence[i][1]);
			c.x = (c.x + dx[d]*(s%N)+N)%N;
			c.y = (c.y + dy[d]*(s%N)+N)%N;
			basket[c.x][c.y]++; // 1씩 늘린다.
		}
		
		
		// 물복사 버그
		while(!q.isEmpty()) {
			cloud c = q.poll();
			isVisited[c.x][c.y] =true;
			for(int j=1; j<=7; j+=2) {
				int n1x = c.x+dx[j];
				int n2y = c.y+dy[j];
				if(n1x<0 || n2y<0 || n1x>=N || n2y>=N || basket[n1x][n2y] <1)continue;
				basket[c.x][c.y]++;
			}
		}
		
	
		
		//구름 처리
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isVisited[i][j]&& basket[i][j]>=2) {
					basket[i][j]-=2;
					q.add(new cloud(i,j));
				}
			}
		}
		
	}
	
	
	static class cloud{
		int x;
		int y;
		
		public cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}