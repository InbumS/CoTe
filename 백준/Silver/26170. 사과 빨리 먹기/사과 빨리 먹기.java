import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[5][5];
        isVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==-1)isVisited[i][j]=true;
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        isVisited[r][c]=true;
        // DFS 수행
        DFS(r, c, 0, 0);

        // 결과 출력
        if(answer == Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(answer);
    }

    static void DFS(int x, int y, int count, int depth) {
        if (depth == 3) {
            answer = Math.min(answer, count);
            return;
        }

        if (answer < count) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (ax < 0 || ay < 0 || ax >= 5 || ay >= 5 || isVisited[ax][ay]) continue;
            if (board[ax][ay] == 1) {
                board[ax][ay] = 0;  
                isVisited[ax][ay]=true;
                DFS(ax, ay, count + 1, depth + 1);
                board[ax][ay] = 1;  
                isVisited[ax][ay]=false;
            } else {
            	isVisited[ax][ay]=true;
                DFS(ax, ay, count + 1, depth);
                isVisited[ax][ay]=false;
            }
        }
    }
}