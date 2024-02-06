import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int [][] arr;
    static int [] dx = {0, 1, 0,-1};
    static int [] dy = {1, 0 ,-1, 0};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int [N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<R; i++) {
            Rotation(arr);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void Rotation(int [][] arr) {
        int width = arr.length;
        int height = arr[0].length;
        // 회전 시킬 수
        int minNum = Math.min(width, height)/2;

        for(int i=0; i<minNum; i++) {
        	int x=i,y=i;
        	int idx =0;
        	// 초기화 값 즉 마지막 index 요소에다가 삽입
        	int last = arr[x][y];
        	while(true) {
        		if(idx==4)
        			break;
        		// 움직인 값 저장
        		int ax = x+dx[idx];
        		int ay = y+dy[idx];
        		
        		
        		if(ax < width-i && ay <height-i && ax >= i && ay >= i) {
    				arr[x][y] = arr[ax][ay];
    				x = ax;
    				y = ay;
    			} 
    			else {
    				idx++;
    			}
        		
        		
    			
    		}arr[i+1][i]=last;

        	}

        }
    }