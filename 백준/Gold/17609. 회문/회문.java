import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int idx=0; idx<n; idx++) {
        String line = sc.next();
        int left = 0;
        int right = line.length()-1;
        int cnt = 0;
        
        int flag = match(line, left, right, 0);
    
        System.out.println(flag);
    	}
	}

	static int match(String line, int left, int right, int cnt) {
		
		while(left<right) {
			
			if(line.charAt(left)==line.charAt(right)) {
				left++;
				right--;
				continue;
			}if(cnt !=0)
				return 2;
			
			cnt++;
			int res = match(line, left, right-1, cnt);
			if(res == 1) {
				right--;
				continue;
			}
			
			res = match(line, left+1, right, cnt);
			if(res == 1) {
				left++;
				continue;
			}
			
			
		}	
		return cnt;
	}
 
}