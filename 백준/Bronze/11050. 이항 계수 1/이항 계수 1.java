import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int top = 1;
		int bottom =1;
		for(int i=n; i>n-k; i--) {
			top *= i;
			
		}
		for(int i=k; i>0; i--) {
			bottom *= i;
		}
		System.out.println(top/bottom);
		

	}

}