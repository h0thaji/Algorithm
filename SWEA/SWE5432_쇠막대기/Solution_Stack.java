package SWE5432_쇠막대기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class Solution_Stack {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int TC = Integer.parseInt(bf.readLine());
		
		Stack<Character> stack;

		for (int t = 1; t <= TC; t++) {
			//파이프 입력
			stack= new Stack<Character>();
			String pipe = bf.readLine();
			char charPop ;
			int cnt = 0;
			int result = 0;
//			'('바로 다음')'면 레이저
//			레이저를 만나면 열린 괄호 수(파이프 수) 만큼 잘린다
//			괄호가 닫힐 때 파이프 하나가 잘린다 , 파이프 개수를 하나 빼준다
			
			for (int i = 0; i < pipe.length(); i++) {
				char c = pipe.charAt(i);
				if(c == '(') {
					stack.push(c);
					if(')' == pipe.charAt(i+1)) {
						stack.pop();
						i++;
						result += stack.size();
					}
				}
				else if(c == ')') {
					stack.pop();
					result++;
				}
				
			}
//			for (int i = 0; i < pipe.length(); i++) {
//				stack.push(pipe.charAt(i));
//			}
//			while(!stack.isEmpty()) {
//				charPop = stack.pop();
//				if(charPop == ')') {					
//					if(stack.peek() == '(') {
//						result += cnt;
//						stack.pop();
//					}
//					else cnt++;
//				}
//				else if(charPop == '(') {
//					cnt--;
//					result++;
//				}
//			}
			bw.write("#"+t+" "+result+"\n");
		}
		bf.close();

		bw.flush();
		bw.close();
	}
}





