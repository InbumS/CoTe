import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int total =0;
	static int N,M;
	static int [][] grid;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int [N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 다 4칸이다.
		// 모든 방면을 다 바라본다
		check1();
		check2();
		check3();
		check4();
		check5();
		System.out.println(total);
	}
	// 4x1
	public static void check1() {
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<M-3; j++) {
				sum = grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i][j+3];
				total = Math.max(total, sum);
			}
		}
		
		for(int i=0; i<N-3; i++) {
			int sum = 0;
			for(int j=0; j<M; j++) {
				sum = grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i+3][j];
			 	total = Math.max(total, sum);
			}
		}	
	}
	
	// 2x2
	public static void check2() {
		for(int i=0; i<N-1; i++) {
			int sum = 0;
			for(int j=0; j<M-1; j++) {
				sum = grid[i][j]+grid[i+1][j]+grid[i][j+1]+grid[i+1][j+1];
				total = Math.max(total, sum);
			}
		}
	}
	
	
	//3x2
	public static void check3() {
		
		for(int i=0; i<N-1; i++) {
			int sum = 0, sum2 = 0, sum3=0, sum4=0;
			for(int j=0; j<M-2; j++) {
				sum = grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i+1][j+2];
				sum2= grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]+grid[i][j+2];
				sum3 =grid[i][j]+grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
				sum4 = grid[i][j]+grid[i+1][j]+grid[i][j+1]+grid[i][j+2];
				total = Math.max(total, sum);
				total = Math.max(total, sum2);
				total = Math.max(total, sum3);
				total = Math.max(total, sum4);
			}
		}
		
		for(int i=0; i<N-2; i++) {
			int sum = 0, sum2 = 0, sum3=0, sum4=0;
			for(int j=0; j<M-1; j++) {
				sum = grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i+2][j+1];
				sum2= grid[i][j]+grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
				sum3 =grid[i+2][j]+grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
				sum4 = grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i][j+1];
				total = Math.max(total, sum);
				total = Math.max(total, sum2);
				total = Math.max(total, sum3);
				total = Math.max(total, sum4);
			}
		}
		
	}
	
	//1x2x1
	public static void check4() {
		for(int i=0; i<N-1; i++) {
			int sum = 0, sum2 = 0;
			for(int j=0; j<M-2; j++) {
				sum = grid[i][j]+grid[i][j+1]+grid[i+1][j+2]+grid[i+1][j+1];
				sum2= grid[i+1][j]+grid[i+1][j+1]+grid[i][j+2]+grid[i][j+1];
				total = Math.max(total, sum);
				total = Math.max(total, sum2);
			}
		}
		
		for(int i=0; i<N-2; i++) {
			int sum = 0, sum2 = 0;
			for(int j=0; j<M-1; j++) {
				sum = grid[i][j]+grid[i+1][j]+grid[i+2][j+1]+grid[i+1][j+1];
				sum2= grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j]+grid[i+1][j];
				total = Math.max(total, sum);
				total = Math.max(total, sum2);
			}
		}
	}
	// 3x1
	public static void check5() {
		for(int i=0; i<N-2; i++) {
			int sum = 0, sum2 = 0;
			for(int j=0; j<M-1; j++) {
				sum = grid[i][j]+grid[i+1][j]+grid[i+2][j]+grid[i+1][j+1];
				sum2 = grid[i][j+1]+grid[i+1][j]+grid[i+2][j+1]+grid[i+1][j+1];
				total = Math.max(total, sum);
				total = Math.max(total, sum2);
			}
		}
		
		for(int i=0; i<N-1; i++) {
			int sum = 0, sum2= 0;
			for(int j=0; j<M-2; j++) {
				sum = grid[i+1][j]+grid[i+1][j+1]+grid[i][j+1]+grid[i+1][j+2];
				sum2 = grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i+1][j+1];
			 	total = Math.max(total, sum);
			 	total = Math.max(total, sum2);
			}
		}	
		
	}
	
}