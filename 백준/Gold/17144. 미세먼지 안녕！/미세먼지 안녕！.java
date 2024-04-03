import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int R, C; 

    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static void spread(int[][] grid, Queue<int[]> P_air) {
        int[][] what = new int[R][C]; 

        while (!P_air.isEmpty()) {
            int[] cur = P_air.poll();
            int nx = cur[0];
            int ny = cur[1];
            int dust = grid[nx][ny];

            for (int i = 0; i < 4; i++) {
                int ax = nx + dx[i];
                int ay = ny + dy[i];
                
                if (isValid(ax, ay) && grid[ax][ay] != -1) {
                	what[ax][ay] += dust / 5;
                	if(grid[nx][ny]>0) {
                		grid[nx][ny] -= dust / 5;
                	}
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] += what[i][j];
            }
        }
    }

    
    static void airconMove(int[][] grid, List<int[]> Machine) {
        // 위쪽 공기청정기
        int top = Machine.get(0)[0];
        int bottom = Machine.get(1)[0];
       
        
        // 오른쪽
        for (int x = top - 1; x > 0; x--) {
        	grid[x][0] = grid[x - 1][0];
        }
 
        for (int y = 0; y < C - 1; y++) {
        	grid[0][y] = grid[0][y + 1];
        }
 
        for (int x = 0; x < top; x++) {
        	grid[x][C - 1] =grid[x + 1][C - 1];
        }
 
        for (int y = C - 1; y > 1; y--) {
        	grid[top][y] = grid[top][y - 1];
        }
 
        grid[top][1] = 0;
 
 
        for (int x = bottom + 1; x < R - 1; x++) {
        	grid[x][0] = grid[x + 1][0];
        }
 
        for (int y = 0; y < C - 1; y++) {
        	grid[R - 1][y] = grid[R - 1][y + 1];
        }
 
        for (int x = R - 1; x > bottom; x--) {
        	grid[x][C - 1] = grid[x - 1][C - 1];
        }
 
        for (int y = C - 1; y > 1; y--) {
        	grid[bottom][y] = grid[bottom][y - 1];
        }
 
        grid[bottom][1] = 0;
    
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<int[]> Machine = new ArrayList<>();
        Queue<int[]> P_air = new ArrayDeque<>();
        int[][] grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == -1) {
                    Machine.add(new int[]{i, j});
                } else if (grid[i][j] > 0) {
                    P_air.add(new int[]{i, j});
                }
            }
        }

        while (t-- > 0) {
            spread(grid, P_air);
            airconMove(grid, Machine);
            for(int i=0; i<R; i++) {
            	for(int j=0; j<C; j++) {
            		if(grid[i][j] > 0)P_air.add(new int[] {i,j});
            	}
            	
            }
           
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0) answer += grid[i][j];
            }
        }
        
        System.out.println(answer);
    }
}