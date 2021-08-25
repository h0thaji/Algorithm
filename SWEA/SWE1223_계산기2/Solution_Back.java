package SWE1223_계산기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_Back {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<String> stack = new Stack<>();
		Stack<Integer> sum = new Stack<>();

		String postfix = "";

		for (int t = 1; t <= 10; t++) {
			bw.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());			
			String cal = br.readLine();
			for (int i = 0; i < cal.length(); i++) {
				
				if(cal.charAt(i) >= '0' && cal.charAt(i) <= '9') postfix += cal.charAt(i); // 해당 문자열이 피연산자일때 String postfix에 삽입
				
				else { // 연산자일때
					if(stack.isEmpty()) stack.push(String.valueOf(cal.charAt(i))); // 스택이 비어있다면 스택에 푸쉬
					
					else {// 비어 있지 않다면
						
						if(cal.charAt(i) == '+') while(!stack.isEmpty()) postfix += stack.pop(); // 연산자가 +면 스택 데이터 모두 postfix 문자열에 삽입
						
						else while(!stack.isEmpty() && stack.peek() == "*") postfix += stack.pop(); // +가 아니고 *이 스택 마지막에 담겼다면 스택데이터 모두 postfix에 삽입
						
						stack.push(String.valueOf(cal.charAt(i))); // 해당 연산자 스택에 푸쉬
					}
				}			

			}
			while(!stack.isEmpty()) postfix += stack.pop(); // 스택에 남은 것들 털기

			
//			System.out.println(postfix); // 후위연산확인
			
			for (int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				
				if( c >= '0' && c <= '9') sum.push(c-'0');
				else {
					int num1 = sum.pop();
					int num2 = sum.pop();
					switch(c) {
					case '+':
						sum.push(num1 + num2);
						break;
					case '*':
						sum.push(num1 * num2);
						break;
					}
				}
			}
			bw.append(sum.pop()+"\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}
}

