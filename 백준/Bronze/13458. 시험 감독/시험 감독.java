import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++)arr[i] = sc.nextInt();
		int leader = sc.nextInt();
		int vice = sc.nextInt();
		long minNum =0;
		for(int i=0; i<arr.length; i++) {
			minNum++;
			arr[i]-=leader;
			if(arr[i]<=0)continue;
			
			if(arr[i]%vice==0)minNum+=arr[i]/vice;
			else minNum+=(arr[i]/vice)+1;
			
		}
		System.out.println(minNum);
		
	}

}