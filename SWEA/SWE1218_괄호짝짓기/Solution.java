package SWE1218_괄호짝짓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static int[] left, right;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

			
		for (int t = 1; t <= 3; t++) {
			sb.append("#"+t+" ");
			left = new int[4];
			 right = new int[4];
			
			int TC = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				
				if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					switch(str.charAt(i)) {
					case '(':
						left[0]++;
						break;
					case '[':
						left[1]++;
						break;
					case '{':
						left[2]++;
						break;
					case '<':
						left[3]++;
						break;
					}
				}
				else {
					switch(str.charAt(i)) {
					case ')':
						right[0]++;
						break;
					case ']':
						right[1]++;
						break;
					case '}':
						right[2]++;
						break;
					case '>':
						right[3]++;
						break;
					}
				}
			}
			boolean check = false;

			for(int i = 0; i < 4; i++) {
				if(left[i] != right[i]) {
					check = false;
					break;
				}
				else check = true;
			}
			sb.append(check ? (1+"\n") : (0+"\n")) ;
			
		}
		System.out.println(sb);

	}

}
