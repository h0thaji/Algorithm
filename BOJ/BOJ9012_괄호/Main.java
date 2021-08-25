package BOJ9012_괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String input = br.readLine();
			Stack<Character> s = new Stack<>();
			
			for(int i = 0; i < input.length(); i++) {
				if(!s.isEmpty()) {
					if(s.peek() =='(' && input.charAt(i) == ')') s.pop();
					else s.push(input.charAt(i));
				}else s.push(input.charAt(i));
			}
			
			sb.append(s.isEmpty()? "YES\n" : "NO\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}

}
