package SWE5432_쇠막대기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int TC = Integer.parseInt(bf.readLine());


		for (int t = 1; t <= TC; t++) {
			//파이프 입력
			String pipe = bf.readLine();

			int cnt = 0;
			int result = 0;
//			'('바로 다음')'면 레이저
//			레이저를 만나면 열린 괄호 수(파이프 수) 만큼 잘린다
//			괄호가 닫힐 때 파이프 하나가 잘린다 , 파이프 개수를 하나 빼준다
			for (int i = 0; i < pipe.length(); i++) {
				if(pipe.charAt(i) == '(') { 
					if(pipe.charAt(i+1) == ')') { //'(' 다음에 ')' 오면 레이져
						result += cnt; // '(' 수 만큼 잘린 파이프
						i++; // 다음 입력 넘기기
					}
					else cnt++;	// 레이저가 아니면 '(' 수 추가				
				}
				else if(pipe.charAt(i) == ')') { // 막대기 끝날때
					cnt--; // 막대기 하나 빼줌
					result++; // 잘린 꼬다리 파이프 추가
				}
			}
			bw.write("#"+t+" "+result+"\n");
		}
		bf.close();

		bw.flush();
		bw.close();
	}
}





