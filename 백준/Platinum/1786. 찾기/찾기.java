import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// thanks to 지은
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String target = br.readLine();
		int what = 0;
		int [] fail =  new int[100_000_1];
		int [] check = new int[100_000_1];
		
		// 실패 배열 생성
		int idx = 0;
		for(int i=1; i< target.length(); i++) {
			while(idx >0 && target.charAt(i) != target.charAt(idx)) {
				// 다른 순간
				idx = fail[idx-1]; // 실패 지점 전 위치 이동
			}
			if(target.charAt(i) == target.charAt(idx)) {
				fail[i] = ++idx;
			}
		}
		
		// 문자열 비교
		int compare = 0;
		for(int i=0; i<line.length(); i++) {
			while(compare > 0 && line.charAt(i)!= target.charAt(compare)) {
				compare = fail[compare-1];
			}
			if(line.charAt(i)== target.charAt(compare)){
				++compare;
			}
			// 정답 나올시 다시 위치 재조정
			if(compare >= target.length()) {
				check[what] = i-target.length()+1;
				what++;
				compare = fail[compare-1];
			}
		}
		
		System.out.println(what);
		for(int i=0; i<what; i++) System.out.print(check[i]+1+" ");
		
	}

}