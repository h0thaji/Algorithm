package BOJ17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack st = new Stack();
		boolean check = false;

		for (int i =  0; i < str.length(); i++) {

			if(str.charAt(i) == '<' ) {
				print(st);
				sb.append(str.charAt(i));
				check = true;
			}
			else if(str.charAt(i) == '>') {
				check = false;
				sb.append(str.charAt(i));

			}
			else if(check) sb.append(str.charAt(i));

			else {
				if(str.charAt(i) == ' ') {
					print(st);
					sb.append(str.charAt(i));
				}
				else {
					st.push(str.charAt(i));
				}
			}
		}
		print(st);

		System.out.println(sb);
	}

	public static void print(Stack st) {
		while(!st.isEmpty()) {
			sb.append(st.pop());

		}
	}

}
