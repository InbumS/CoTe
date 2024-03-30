import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t= Integer.parseInt(br.readLine());
		for(int idx = 0; idx<t;  idx++) {
			// floyd - warshall?
			List<int []>info = new ArrayList<int[]>(); // 가변 배열
			int n = Integer.parseInt(br.readLine()); // 편의점 갯수
			st = new StringTokenizer(br.readLine());
			// 편의점 갯수 입력?				
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			info.add(new int[] {x,y}); // 좌표 입력
 			for(int k=0; k<n; k++) {
 				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				info.add(new int[] {x,y}); // 더하기
			}
 			st = new StringTokenizer(br.readLine());
 			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			info.add(new int[] {x,y});
 			
			int [][] arr = new int[n+2][n+2];
			for(int i=0; i<n+1; i++) {
				for(int j=i+1; j<n+2; j++) { // 자기 이전 좌표는 볼 필요 없음
					arr[i][j] = arr[j][i] = 9999999;
					if(dist(info.get(i)[0], info.get(i)[1], info.get(j)[0], info.get(j)[1])<=1000) {
						arr[i][j] = arr[j][i] = 1;
					}
				}
			}
			
			// 계산!
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					for(int k=0; k<n+2; k++) {
						arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
						
					}
				}
			}
			if(arr[0][n+1] < 9999999)System.out.println("happy");
			else System.out.println("sad");
			
			
			
			
		}
	}
	static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}