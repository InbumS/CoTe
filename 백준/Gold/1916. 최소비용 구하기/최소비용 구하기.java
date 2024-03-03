import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static List<List<bus>>city;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		city = new ArrayList<>(N+1);
		int [] dist = new int[N+1];
		// init graph
		for(int i =0; i<=N; i++) {
			city.add(new ArrayList<>());
		}
		Arrays.fill(dist, 1, N+1, Integer.MAX_VALUE);
		
		
		for(int idx=0; idx<M; idx++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			city.get(s).add(new bus(e,w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 최소 거리 계산
		PriorityQueue<bus> pq = new PriorityQueue<>();
		pq.add(new bus(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			bus cur = pq.poll();
			int curIdx = cur.t;
			int weight = cur.w;
			// 무게가 현재 기록 된것 보다 크면은 패쓰
			if(weight > dist[curIdx])continue;
			
			
			for(bus next : city.get(curIdx)) {
				int tempw = weight+next.w;
				if(tempw < dist[next.t]) {
				dist[next.t]=tempw;
				pq.offer(new bus(next.t, tempw));
				}
				
			}
			
		}
		System.out.println(dist[end]);
	}
	
	
	static class bus implements Comparable<bus>{
		int t;
		int w;
		
		public bus(int t, int w) {
			super();
			this.t = t;
			this.w = w;
		}

		@Override
		public int compareTo(bus o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
	}
}