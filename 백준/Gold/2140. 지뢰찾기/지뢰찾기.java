import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	 static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	 static int[] dy = {0, -1, 1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        int bomb = 0;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int flag = 0;
                if (board[i][j] == '#') {
                    for (int k = 0; k < 8; k++) {
                        int ax = i + dx[k];
                        int ay = j + dy[k];
                        if (ax >= 0 && ax < N && ay >= 0 && ay < N && board[ax][ay] == '0') {
                            flag = 1;
                            break; //  반복문 종료
                        }
                    }

                    if (flag == 0) {
                        for (int k = 0; k < 8; k++) {
                            int ax = i + dx[k];
                            int ay = j + dy[k];
                            if (ax >= 0 && ax < N && ay >= 0 && ay < N && board[ax][ay] != '#') {
                                int numericValue = Character.getNumericValue(board[ax][ay]);
                                board[ax][ay] = (char) ('0' + numericValue - 1);     
                            }
                        }
                        bomb++;
                    }
                }
            }
        }

        System.out.println(bomb);
    }
}