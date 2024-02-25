 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int maxnum = 0;
    static int[][] virus;
    static int N, M;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };
    static Queue<Node> q;
    static List<Node> combination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new int[N][M];
        q = new ArrayDeque<>();
        combination = new ArrayList<>();

        // 입력 부분
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
            	virus[i][j] = Integer.parseInt(st.nextToken());
                if (virus[i][j] == 2) {
                    q.offer(new Node(i, j));
                } else if (virus[i][j] == 0) {
                	combination.add(new Node(i, j));
                }
            }
        }

        // 조합 처리
        boolean[] wallCheck = new boolean[combination.size()];
        Johab(0, 3, 0, wallCheck);

        System.out.println(maxnum);
    }

    
    public static void Johab(int start, int end, int check, boolean wallCheck[]) {
        if (check == end) {
            int[][] temp = deepCopy(virus);
            for (int k = 0; k < wallCheck.length; k++) {
                if (wallCheck[k]) {
                    Node wall = combination.get(k);
                    temp[wall.x][wall.y] = 1;
                }
            }
            maxnum = Math.max(maxnum, Checknum(temp));
            return;
        }
        for (int i = start; i < combination.size(); i++) {
            wallCheck[i] = true;
            Johab(i + 1, end, check + 1, wallCheck);
            wallCheck[i] = false;
        }
    }

    // 모든 2를 다 돌린다.
    public static int Checknum(int[][] temp) {
        int[][] copytemp = deepCopy(temp);
        for (Node virusNode : q) {
            BFS(copytemp, virusNode);
        }
        return Count(copytemp);
    }

    
    public static void BFS(int[][] copytemp, Node start) {
        Queue<Node> virusQ = new ArrayDeque<>();
        virusQ.offer(start);

        while (!virusQ.isEmpty()) {
            Node current = virusQ.poll();
            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax < 0 || ay < 0 || ax >= N || ay >= M || copytemp[ax][ay] != 0)
                    continue;
                copytemp[ax][ay] = 2;
                virusQ.offer(new Node(ax, ay));
            }
        }
    }

    // counting
    public static int Count(int[][] copytemp) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copytemp[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}