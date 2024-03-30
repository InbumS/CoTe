import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String bomb = br.readLine();
		int what = bomb.length();
		
		for(int i=0; i<line.length(); i++) {
			sb.append(line.charAt(i));
			int length = sb.length();
			
			if(length >= what && sb.substring(length - what).equals(bomb)) {
				sb.delete(length-what, length);
			}
			
			
		}
		
		String result = sb.toString();
		if(result.isEmpty())System.out.println("FRULA");
		else System.out.println(result);
		
	}
	
}