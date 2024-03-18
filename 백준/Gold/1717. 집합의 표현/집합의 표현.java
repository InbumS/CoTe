import java.io.*;
import java.util.*;

public class Main {
    static int m,n;
    static int [] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        makeset();
        for(int idx=0; idx<m; idx++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(t==0) {
            	if(a>b) union(a,b);
            	else union(b,a);
            	
            }else if(t==1) {
            	boolean x  = isSame(a,b);
            	if(x == true) System.out.println("YES");
            	else System.out.println("NO");
            }
            else {
            	continue;
            }
        }
    }
    
    static void makeset() {
    	parent = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		parent[i] = i;
    	}
    	// 초기화
    }
    
    static boolean isSame(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x==y) return true;
    	else return false;
    }
    
    
    static int find(int x) {
    	if(parent[x] == x) return x;
    	return parent[x] = find(parent[x]);
    }
    
    static 	void  union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	// 부모까지 따진다
    	if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}