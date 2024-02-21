import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int L;
    static int R;
    static int [][]A;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; 
        boolean flag; 

        do {
            flag = true; // 인구 이동이 없다고 가정
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                    	// 근처 가능한 공간 저장
                        List<Node> union = new ArrayList<>();
                        int total = bfs(i, j, union);
                        if (union.size() > 1) { 
                            flag = false; 
                            int newpopulation = total / union.size();
                            for (Node node : union) {
                                A[node.x][node.y] = newpopulation; 
                            }
                        }
                    }
                }
            }

            if (!flag) cnt++; 
        } while (!flag);

        System.out.println(cnt);
    }

    static int bfs(int x, int y, List<Node> union) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        union.add(new Node(x, y));
        int total = A[x][y]; // 연합 총 인구수

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(A[current.x][current.y] - A[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        union.add(new Node(nx, ny));
                        total += A[nx][ny];
                    }
                }
            }
        }

        return total;
    }

   
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}