package SWE1223_계산기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();

		for (int t = 1; t <= 10; t++) {


			int N = Integer.parseInt(br.readLine());			
			String cal = br.readLine();

			int result = 0;

			for(int i = 0; i < N; i++) {
				if(cal.charAt(i) != '*' && cal.charAt(i) != '+') {
					stack.push(Integer.parseInt(cal.charAt(i)+""));
				}
				else if(cal.charAt(i) == '*') {
						stack.push(stack.pop() * Integer.parseInt(cal.charAt(i+1)+""));
						i++;
				}
				
			}
			while(!stack.isEmpty()) result += stack.pop();
			
			bw.write("#"+t+" "+result+"\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}
}
