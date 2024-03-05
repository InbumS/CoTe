import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] belt;
	static int K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N];
		boolean [] robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<belt.length; idx++)belt[idx] = Integer.parseInt(st.nextToken());
		int step = 0;
		while(check()) {
			step++;
			int temp = belt[2*N-1];
			// 1번 수행
			for(int i=belt.length-1; i>0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = temp;
			
			for(int i=N-1; i>0; i--) {
				robot[i] = robot[i-1];
			}
			// 오르기전 초기화
			robot[0] = false;
			// 내리기
			robot[N-1] = false;
		
			
			// 2번 수행 
			for(int i=N-1; i>0; i--) {
				if(belt[i]>=1 && !robot[i]&&robot[i-1]) {
					belt[i]--;
					robot[i]=true;
					robot[i-1]=false;
				}
			}
			
			//3번 올리기
			if(belt[0]>=1) {
				belt[0]--;
				robot[0]=true;
			}
			
		}
		
		System.out.println(step);
		
	}
	
	static boolean check() {
		int cnt=0;
		for(int idx=0; idx<belt.length; idx++) {
			if(belt[idx]==0)cnt++;
			if(cnt >= K)return false;
		}
		return true;
	}

}