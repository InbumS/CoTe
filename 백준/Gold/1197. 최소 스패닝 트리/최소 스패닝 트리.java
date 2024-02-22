import java.io.*;
import java.util.*;
 
public class Main {
    static int[] parent;
    static int V;
    public static class node implements Comparable<node> {
        int start;
        int end;
        int weight;
 
        public node(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
 
        // 간선 정렬
        @Override
        public int compareTo(node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        // 값 입력
        long total = 0;
        List<node> SpanningTree = new ArrayList<>();
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            SpanningTree.add(new node(A - 1, B - 1, C));
 
        }
 
        total = kruscal(SpanningTree, V);
        System.out.println(total);
        }
 
    
 
    ////////////// 유니온-파인드///////////////////////////
    static void make_set(int v) {
        parent = new int[v];
        for (int i = 0; i < v; i++) parent[i] = i;
    }
 
    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
 
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) return false;
        parent[A] = B;
        return true;
    }
 
    ////////////// 크루스칼 ///////////////////////////////
    public static long kruscal(List<node> graph, int v) {
        long weight = 0, cnt=0;
        Collections.sort(graph);
        make_set(v);
         
 
        for (node n : graph) {
            if (union(n.start, n.end)) {
                weight += n.weight;
                if(++cnt==V-1)break;
            }
        }
 
        return weight;
    }
}