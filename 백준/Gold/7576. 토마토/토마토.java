import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[]= {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [][] tomato = new int[N][M]	;
		boolean [][] visit = new boolean[N][M];
		Queue<node>q = new ArrayDeque<>();
		int total=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j]==1) {
					q.add(new node(i,j));
					visit[i][j] = true;
				}
				else if (tomato[i][j]==0) {
					total++;
				}
			}
		}
		int answer = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int k=0; k<size; k++) {
				node current = q.poll();
				for(int idx =0; idx<4; idx++) {
				int ax = current.x+dx[idx];
				int ay = current.y+dy[idx];
				
				if(ax<0 || ay<0 || ax>=N || ay>=M || visit[ax][ay]||tomato[ax][ay] == -1)continue;
				visit[ax][ay]=true;
				total--;
				q.add(new node(ax,ay));
				
				}
			}
			answer++;
		}
		
		if(total!=0) {
			System.out.println(-1);
		}else {
		System.out.println(answer-1);
		}
		
	}
	
	public static class node{
		int x;
		int y;
		
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}