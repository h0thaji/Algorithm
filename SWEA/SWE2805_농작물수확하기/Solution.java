package SWE2805_농작물수확하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {

	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		String str;
		int TC = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(bf.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				str = bf.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] =Integer.parseInt(
							""+str.charAt(j));
				}
			}

			int cnt = 1;
			int scnt = 0;
			int sum = 0;
			int dj = N/2;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				
				if(flag == false) {
					dj = N/2 - scnt;
					for(int c = cnt; c > 0; c--) {
						sum+= map[i][dj];
						dj++;
					}
					scnt++;
					cnt = cnt + 2;
				}
				else {
					cnt = cnt - 2;
					scnt--;
					dj = N/2 - scnt;					
					for(int c = cnt; c > 0; c--) {
						sum+= map[i][dj];
						dj++;
					}
					
					
				}
				if(i == (N/2)) {
					flag =true;
					scnt--;
					cnt = cnt -2;
				}
			}

			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb);
	}

}
