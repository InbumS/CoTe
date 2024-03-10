import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph;
    static int bfs(int start, boolean [] isVisited) {
		int result=1;
		Queue<Integer>q =  new ArrayDeque<Integer>();
		q.add(start);
		isVisited[start]=true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int c: graph.get(current)) {
				if(!isVisited[c]) {
					isVisited[c]=true;
					result++;
					q.add(c);
				}
			}
		}
		
		
		return result;
	}
    public int solution(int n, int[][] wires) {
               int answer = n;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++)graph.add(new ArrayList<Integer>()); //초기화
        
        for(int [] w: wires) {
        	graph.get(w[0]).add(w[1]);
        	graph.get(w[1]).add(w[0]); //연결 정보 
        }
        
        for(int []w: wires) {
        	boolean [] isVisited = new boolean[n+1];
        	isVisited[w[1]] =true;
        	int result = bfs(w[0], isVisited);
        	if(Math.abs(result-(n-result))<answer){
        		answer = Math.abs(result-(n-result));
        	}
        }
        
        
        return answer;
    }
}