import java.util.*;
import java.io.*;


public class Main {
	static int n;
	static int arr[][];
	static int result = Integer.MAX_VALUE;
	static int [] division;
	static boolean [][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int totalNum = 0;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				totalNum += arr[i][j];
			}
		}
		// 입력 끝
		// 구해야 되는 범위는 d1, d2의 범위동안은 다 구해야 할듯?
		// d1, d2 조건은 1보다 크다 
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				for(int d1=1; d1<n-1; d1++) {
					for(int d2=1; d2<n-1; d2++) {
						if(x+d1+d2>=n)continue;
						if(y-d1<0)continue;
						if(y+d2>=n)continue; 
						// 제약 조건 처리
						isVisited =  new boolean[n][n];
						for(int idx=0; idx<=d1; idx++) {
							isVisited[idx+x][y-idx] = true;
							isVisited[x+d2+idx][y+d2-idx]=true;
						}
						for(int idx=0; idx<=d2; idx++) {
							isVisited[idx+x][y+idx] = true;
							isVisited[x+d1+idx][y-d1+idx]=true;
						}
						check(x,y,d1,d2,totalNum);
						
					}
				}
			}
		}	
		///////////////////////////
		System.out.println(result);
	}
	
	// check logic
	public static void check(int x, int y, int d1,int d2, int totalNum) {
		division = new int[5];
		// r,c checking
		for(int r=0; r<x+d1; r++) {
			for(int c=0; c<=y; c++) {
				if(isVisited[r][c])break;
				division[0]+=arr[r][c];
			}
		}
		for(int r=0; r<=x+d2; r++) {
			for(int c=n-1; c>y; c--) {
				if(isVisited[r][c])break;
				division[1]+=arr[r][c];
			}
		}
		
		for(int r=x+d1; r<n; r++) {
			for(int c=0; c<y-d1+d2; c++) {
				if(isVisited[r][c])break;
				division[2]+=arr[r][c];
			}
		}
		
		for(int r=x+d2+1; r<n; r++) {
			for(int c=n-1; c>=y-d1+d2; c--) {
				if(isVisited[r][c])break;
				division[3]+=arr[r][c];
			}
		}
		
		division[4] = totalNum - (division[0]+division[1]+division[2]+division[3]);
		Arrays.sort(division);
		result = Math.min(division[4]-division[0], result);
		
	}

}