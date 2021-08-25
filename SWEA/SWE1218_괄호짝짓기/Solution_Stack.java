package SWE1218_괄호짝짓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_Stack {

	static int[] left, right;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		Stack<Character> stack = new Stack<>();

		for (int t = 1; t <= 10; t++) {
			sb.append("#"+t+" ");

			int TC = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean check = true;
			for (int i = 0; i < str.length(); i++) {

				if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
				}
				else {
					if(!stack.isEmpty()) {
						if(( stack.peek() == '(' && str.charAt(i) == ')')||( stack.peek() == '[' && str.charAt(i) == ']') ||
								( stack.peek() == '{' && str.charAt(i) == '}') ||( stack.peek() == '<' && str.charAt(i) == '>')	) stack.pop();
						else {
							check = false;
							break;	
						}

					}
					else {
						check = false;
						break;			
					}
				}
			}
			sb.append(check ? (1+"\n") : (0+"\n")) ;

		}
		System.out.println(sb);



	}
}
