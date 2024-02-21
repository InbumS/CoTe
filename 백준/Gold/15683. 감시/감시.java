import java.io.*;
import java.util.*;

public class Main {
    static int result;
    static int target = 0;
    static int N,M;
    static int room[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    static int [ ]rot_size = {4,2,4,4,1}; // 1번 , 2번 ... 5번 카메라 회전가능 크기 
    static int cctv_size = 0;
    static node [] cctv = new node[8];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int [N][M];
        for (int i = 0; i < 8; i++) {
            cctv[i] = new node(0, 0, 0);
        }
        
        for(int row=0; row<N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<M; col++) {
                room[row][col]=Integer.parseInt(st.nextToken());
                if(room[row][col]==1 || room[row][col]==2 || room[row][col]==3|| room[row][col]==4 || room[row][col]==5) {
                	cctv[cctv_size].y = row;
                	cctv[cctv_size].x = col;
                	cctv[cctv_size].type = room[row][col]-1;
                	cctv_size++;
                }

            }}
       
        result=Integer.MAX_VALUE;
        backtracking(0);
        System.out.println(result);

    }
    
    static void copy_array(int desc[][], int src[][]) {
    	for(int y=0; y<N; y++) {
    		for(int x=0; x<M; x++)
    			desc[y][x] = src[y][x];

    	}
    }
    
    static void update(int dir, node cctv) {
    	dir = (dir%4);
    	// 오른쪽
    	if(dir==0) {
    		for(int x=cctv.x+1; x<M; x++) {
    			if(room[cctv.y][x]==6) break;
    			// 감시는 -1로 마킹
    			room[cctv.y][x] = -1;
    			
    		}
    	}
    	// 위쪽
    	if(dir==1) {
    		for(int y = cctv.y-1; y>=0; y--) {
    			if(room[y][cctv.x]==6) break;
    			// 감시는 -1로 마킹
    			room[y][cctv.x] = -1;
    		}
    	}
    	// 서쪽
    	if(dir==2) {
    		for(int x = cctv.x-1; x>=0; x--) {
    			if(room[cctv.y][x]==6) break;
    			// 감시는 -1로 마킹
    			room[cctv.y][x] = -1;
    		}
    	}
    	
    	// 아래쪽
    	if(dir==3) {
    		for(int y = cctv.y+1; y<N; y++) {
    			if(room[y][cctv.x]==6) break;
    			// 감시는 -1로 마킹
    			room[y][cctv.x] = -1;
    		}
    	}
    	
    }
   
    
    
    // 백트래킹으로 내가 얼마나 가는지 확인
    static void backtracking(int cctv_index) {
       if(cctv_index ==cctv_size) {
    	  //count부분
    	  int check=0;
    	  for(int y=0; y<N; y++) {
    		  for(int x=0; x<M; x++) {
    			  if(room[y][x]==0) {
    				  check++;}
    		  }
    	  }
    	  result = Math.min(result, check);
    	  return;   
       }
       int temp [][] = new int[8][8];
       int type = cctv[cctv_index].type;
       // 각각의 cctv 종류에 따라서 반복문 탐색
       for(int dir = 0; dir<rot_size[type]; dir++) {
    	   // map backup
    	   //int[][] temp = Arrays.copyOf(room, room.length);
    	   copy_array(temp, room);
    	   // map update
    	   if(type==0) {
    		   // 지금 몇번째 방향으로 탐색하는지 정보와 x,y 정보
    		   update(dir, cctv[cctv_index]);
    		   
    	   }else if(type==1) {
    		   update(dir, cctv[cctv_index]);
    		   update(dir+2, cctv[cctv_index]);
    	   }
    	   else if(type==2) {
    		   update(dir, cctv[cctv_index]);
    		   update(dir+1, cctv[cctv_index]);
    	   }
    	   else if(type==3) {
    		   update(dir, cctv[cctv_index]);
    		   update(dir+1, cctv[cctv_index]);
    		   update(dir+2, cctv[cctv_index]);
    	   }
    	   else if(type==4) {
    		   update(dir, cctv[cctv_index]);
    		   update(dir+1, cctv[cctv_index]);
    		   update(dir+2, cctv[cctv_index]);
    		   update(dir+3, cctv[cctv_index]);
    	   }
    	
    	   backtracking(cctv_index+1); 
    	   //room = Arrays.copyOf(temp, temp.length);
    	   copy_array(room, temp);
       }
       
       
    }
    

static public class node{
    int x;
    int y;
    int type;
    public node(int x, int y, int type) {
        super();
        this.x = x;
        this.y = y;
        this.type = type;
    } 
}    
}