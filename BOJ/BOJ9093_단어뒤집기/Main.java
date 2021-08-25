package BOJ9093_단어뒤집기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
//		while(T-- > 0) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			Stack<Character> stack = new Stack<>();
//			
//			while(st.countTokens() != 0) {
//				String s = st.nextToken();
//				for(int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
//				while(!stack.isEmpty()) sb.append(stack.pop());
//				sb.append(" ");
//			}
//			sb.append("\n");
//		}
		while(T-- > 0) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			while(st.countTokens() != 0) {
				String input = st.nextToken();
				
				for(int j = input.length()-1; j >= 0; j--) {
					sb.append(input.charAt(j));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}

}
