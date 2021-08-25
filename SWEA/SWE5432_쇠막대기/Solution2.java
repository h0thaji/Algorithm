package SWE5432_쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static StringTokenizer tokens;  static int T;
	 static String line;  public static void main(String[] args) throws IOException {
	 input = new BufferedReader(new StringReader(src));

	 T = Integer.parseInt(input.readLine());

	 for (int t = 1; t <= T; t++) {
	     line = input.readLine();
	     int stickCnt=0;
	     int pieces = 0;
	     char pre = '\u0000';
	     
	     for(int i=0; i<line.length(); i++) {
	         // 여는 괄호를 만나면 스틱의 개수가 증가된다.
	         if(line.charAt(i)=='(') {
	             stickCnt++;
	         }
	         // 닫는 괄호를 만나면...
	         else {
	             stickCnt--;
	             // 레이저인가?
	             if(pre=='(') {
	                 pieces += stickCnt;
	             }
	             // 레이저가 아니면?? 그냥 조각이 끝난거
	             else {
	                 pieces++;
	             }
	         }//
	         pre = line.charAt(i);
	     }
	     output.append(String.format("#%d %d%n", t, pieces));
	 }
	 System.out.println(output);
	 }  private static String src = "2\r\n" +
	     "()(((()())(())()))(())\r\n" +
	     "(((()(()()))(())()))(()())";
	}





