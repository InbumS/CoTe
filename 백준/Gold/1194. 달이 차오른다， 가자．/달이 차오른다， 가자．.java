import java.io.*;
import java.util.*;

class node {
    int x;
    int y;
    int sum;
    int bit;

    public node(int x, int y, int sum, int bit) {
        super();
        this.x = x;
        this.y = y;
        this.sum = sum;
        this.bit = bit;
    }
}

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        Queue<node> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '0') q.add(new node(i, j, 0, 0)); // 0인거 찾기
            }
        }

        boolean[][][] isVisited = new boolean[n][m][64]; // 2^6승
        while (!q.isEmpty()) {
            node cur = q.poll();
            if (arr[cur.x][cur.y] == '1') {
                answer = cur.sum;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int ax = dx[k] + cur.x;
                int ay = dy[k] + cur.y;
                if (ax < 0 || ay < 0 || ax >= n || ay >= m) continue;
                if (arr[ax][ay] == '#' || isVisited[ax][ay][cur.bit]) continue; // 벽일때!
                if (Character.isLowerCase(arr[ax][ay])) { // 키를 찾은 경우
                    int num = arr[ax][ay] - 'a';
                    int make = cur.bit | (1 << num); // 비트를 설정한다.
                    isVisited[ax][ay][make] = true;
                    q.add(new node(ax, ay, cur.sum + 1, make));
                } else if (Character.isUpperCase(arr[ax][ay])) { 
                    int door = arr[ax][ay] - 'A';
                    if ((cur.bit & (1 << door)) > 0) { 
                        isVisited[ax][ay][cur.bit] = true;
                        q.add(new node(ax, ay, cur.sum + 1, cur.bit));
                    }
                } else { 
                    isVisited[ax][ay][cur.bit] = true;
                    q.add(new node(ax, ay, cur.sum + 1, cur.bit));
                }
            }
        }

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }
}