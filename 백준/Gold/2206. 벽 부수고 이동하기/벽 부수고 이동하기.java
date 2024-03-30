import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx [] = {0,1,0,-1};
	static int dy [] = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = -1;
		int [][] arr = new int [n][m];
		boolean [][][] isVisited = new boolean [n][m][2];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		
		Queue<node> q = new ArrayDeque<node>();
		q.add(new node(0,0,1,0));
		isVisited[0][0][0] = true; // no use

		while(!q.isEmpty()) {
			node cur = q.poll();
			if(cur.x == n-1 && cur.y == m-1) {
				answer = cur.dist;
				break;
			}
			
			int ax,ay;
			for(int t=0; t<4; t++) {
				ax = cur.x+dx[t];
				ay = cur.y+dy[t]; // isVisited를 먼저 걸어주면 벽을 뜷고 오는걸 판단 못함?
				if(ax<0 || ay<0 || ax>=n || ay>=m) continue;
				// if used 
				if(arr[ax][ay] == 1 && cur.use > 0) continue; // 가지치기
				if(arr[ax][ay] == 0 && !isVisited[ax][ay][cur.use]) {
					// 정상
					isVisited[ax][ay][cur.use] = true;
					q.add(new node(ax,ay,cur.dist+1, cur.use));
				}else {
					if(cur.use == 0 && !isVisited[ax][ay][cur.use+1]) {
						isVisited[ax][ay][cur.use+1] = true;
						q.add(new node(ax,ay, cur.dist+1, cur.use+1));
					}
				}
				
			}			
		}
		
		System.out.println(answer);
	}
	
}


class node{
	int x;
	int y;
	int dist;
	int use;
	
	public node(int x, int y, int dist, int use) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.use = use;
	}
}