package SWE1974_스도쿠검증;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] check; 
	static int[][] map;
	static int[] dx = {0,3,3}, dy = {0,3,3};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			map = new int[9][9]; // 스도쿠 생성

			bw.append("#"+t+" "); // 결과 값 출력해줄 놈 append #1, #2,...
			
			for (int i = 0; i < 9 ; i++) { // 스토쿠 입력
				st = new StringTokenizer(br.readLine()); // 입력 줄 토큰으로 받아				
				for (int j = 0; j < 9; j++) {
					map[i][j]= Integer.parseInt(st.nextToken()); // 토큰 하나씩 넣어줌
				}
			}
			
			// 3x3 씩 찾기
			selected : for (int i = 0; i < 3; i++) {
				int idx, x = 0,y =0;;
				x = x + dx[i]; // i = 0일때 +0, 1일때+3, 2일때 +3
				y = y + dy[i];
				check = new boolean[10]; // 해당 숫자 있는지 체크 배열

				for (int c = y; c < y+3; c++) {		//3x3 해줌				
					for (int r = x; r < x+3; r++) {
						idx = map[c][r]; 
						if(check[idx]) { // 해당 숫자가 있으면 중복이니 
							check[0] = true; // check[0]은 사용하지 않기에 
							break selected; // 반복문 탈출 후
						}
						check[idx] = true;
					}
				}
			}
			if(check[0]) { // 해당 케이스 끝내기
				bw.append(0+"\n"); // 결과값 append
				continue;
			}             

			// 한줄씩 찾기
			int cnt = 2;
			selected : while(cnt -- > 0) { // 가로 , 세로 두번
				int idx;
												
				 for (int y = 0; y < 9; y++) {
					check = new boolean[10];
					for (int x = 0; x < 9; x++) {
						
						idx = cnt == 1? map[x][y] : map[y][x];
						//cnt == 2이면 세로줄 , 1이면 가로줄
						
						if(check[idx]) {
							check[0] = true;
							break selected;
						}
						check[idx] = true;
					}
				}
				
			}
			
			if(check[0]) {
				bw.append(0+"\n");
				continue;
			}
			
			
			bw.append(1+"\n");


		}

		bw.flush();
		bw.close();
		br.close();



	}

}
