package SWE1493_수의새로운연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

// 맨 아래 대각선(row) 부터  맨 위 대각선까지
// row x y value
// 1   1 1 1
// 2   1 2 2
//     2 1 3
// 3   1 3 4
//     2 2 5
//     3 1 6
// 4   1 4 7
//     2 3 8
//     3 2 9
//     4 1 10
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//입력된 값을 좌표로 바꾸기
			int[] coordA = getCoord(a);
			int[] coordB = getCoord(b);
			
			//+연산 진행: 각각 좌표끼리 x,y
			int [] newCoord = {coordA[0] + coordB[0], coordA[1] + coordB[1]};
			// 이 좌표에 해당하는 값은?
			int answer = getValue(newCoord);
			sb.append(String.format("#%d %d%n",t, answer));
			
		}
		System.out.println(sb);
		
	}
	
	static int getValue(int [] coord) {
		int cnt = 1;
		for(int i = 1;; i++) {
			for(int x = 1, y = i; x<=i; x++, y--) {
				if(x==coord[0] && y==coord[1]) {
					return cnt;
				}
				cnt++;
			}
		}
	}
	static int[] getCoord(int value) {
		int cnt = 1;
		for(int i = 1; ; i++) {
			// x좌표는 1부터 i 까지, y좌표는 i부터 1까지
			for(int x = 1, y =i; x<=i; x++, y--) {
				if(value == cnt) return new int[] {x,y};
				cnt++;
			}
		}
	}
	static String src = "2\r\n"
			+"1 5\r\n"
			+"3 9\r\n";
}
