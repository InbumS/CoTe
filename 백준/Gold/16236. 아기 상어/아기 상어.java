import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] space;
    static int time = 0; // 물고기 잡아 먹을 수 있는 시간
    static int size = 2; // 처음 상어 사이즈
    static int eat = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static Shark shark;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 공간 초기화
        int x = 0, y = 0;
        space = new int[N][N];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                space[row][col] = Integer.parseInt(st.nextToken());
                if (space[row][col] == 9) {
                    shark = new Shark(row, col, 0);
                    space[row][col]=0;
                }
            }
        }

        // 상어 찾기
        while (true) {
            Fish what = Find();
            // 못 찾을때 종료
            if (what == null) break;

            time += what.dist;
            eat++;

            // 상어 사이즈 체킹
            if (eat == size) {
                eat = 0;
                size++;
            }

            space[what.x][what.y] = 0;
            shark.x = what.x;
            shark.y = what.y;
        }

        System.out.println(time);
    }

    // 물고기 찾기 함수
    static Fish Find() {
        Queue<Shark> q = new ArrayDeque<>();
        Fish what = null;
        boolean[][] isVisit = new boolean[N][N];
        q.add(shark);
        isVisit[shark.x][shark.y] = true; //초기화

        while (!q.isEmpty()) {
            int count = q.size();
            for (int idx = 0; idx < count; idx++) {
                Shark current = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ax = current.x + dx[i];
                    int ay = current.y + dy[i];

                    if (ax < 0 || ay < 0 || ax >= N || ay >= N || isVisit[ax][ay] || space[ax][ay] > size) continue;
                    isVisit[ax][ay] = true;
                    //갈 수 있는 구간
                    q.add(new Shark(ax, ay, current.dist + 1));
                    if (space[ax][ay] > 0 && space[ax][ay] < size) {
                        if (what == null || (what.x > ax || (what.x == ax && what.y > ay))) { // 위 그리고 왼쪽 확인 작은 순
                            what = new Fish(ax, ay, current.dist + 1);
                        }
                    }
                }
            }	
            if (what != null) {
                return what;
            }
        }
        return what;
    }

    // 물고기 정보
    static class Fish {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // 상어 정보
    static class Shark {
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}