import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[][] sudoku;
    static boolean flag;
    static boolean[][][] check;
    static List<node> q;

    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        sudoku = new int[9][9];
        check = new boolean[3][9][10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
        	 String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] =  line.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    q.add(new node(i, j));
                } else {
                	check[0][i][sudoku[i][j]]=true;
                	check[1][j][sudoku[i][j]]=true;
                	check[2][(i / 3) * 3 + j / 3][sudoku[i][j]]=true;
                }
            }
        }
        // Start DFS 
        DFS(0);
    }
    static void DFS(int idx) {
        if (idx == q.size()) {
        	flag = true;
            print();
            return;
        } 
        
        node cur = q.get(idx);
        for (int i = 1; i <= 9 ; i++) {
            if (isValid(cur.x, cur.y, i)) {
            	sudoku[cur.x][cur.y] = i;
                // 현재 좌표에 배치한 수를 체크 배열에 저장
                check[0][cur.x][i] = true;
                check[1][cur.y][i] = true;
                check[2][(cur.x / 3) * 3 + cur.y / 3][i] = true;
                DFS(idx+1);
                if(flag) return;
                // 재귀가 끝나면, 배열들 다시 원복
                sudoku[cur.x][cur.y] = 0;
                // 현재 좌표에 배치한 수를 체크 배열에 저장
                check[0][cur.x][i] = false;
                check[1][cur.y][i] = false;
                check[2][(cur.x / 3) * 3 + cur.y / 3][i] = false;
            }
        }
    }

    static boolean isValid(int x, int y, int num) {
        if (check[0][x][num] || check[1][y][num] || check[2][(x / 3) * 3 + y / 3][num]) { //1, 2, 3 checking
            return false;
        }
        return true;
    	  //return !(check[0][x][num] || check[1][y][num] || check[2][getSection(x,y)][num]);
    }
    
  


    static void print() {
        for (int[] array : sudoku) {
            for (int k = 0; k < 9; k++) {
                System.out.print(array[k]);
            }
            System.out.println();
        }
    }
}