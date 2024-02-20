import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int [] check = new int[N+1];
    List<List<Integer>>vertax = new ArrayList<List<Integer>>();
    Queue<Integer> q = new ArrayDeque<>(); 
    
    for (int i = 0; i <= N; i++) {
    	vertax.add(new ArrayList<>());
    }

    for(int i=0; i<M; i++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        check[B]++;
        vertax.get(A).add(B);
    }
    // 처음 0인 값 입력
    
    //System.out.println(Arrays.deepToString(vertax));
    for(int i=1; i<=N; i++)
    {
    	if(check[i]==0) {
    		q.add(i);
    		
    	}
    		
    }
    
    while(!q.isEmpty()) {
    	int current = q.poll();
    	sb.append(current).append(" ");
    	for(int i: vertax.get(current)) {
    		check[i]--;
   
    		if(check[i]==0) {
    			q.add(i);
    		}	
    	}
    }
    System.out.println(sb);
    }
}