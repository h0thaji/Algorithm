package SWE5215_햄버거다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] ham;
	static boolean[] v;
	static int N, L, max = 1, kcal, taste, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ham = new int[N][2];
			v = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					ham[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sub(0);

			sb.append("#"+t+" "+max+"\n");



		}
		System.out.println(sb);	
		br.close();

	}
	public static void sub(int cnt) {
		if(cnt == N ) {
			kcal = 0;

			//Arrays.fill(v, false);
			int isSelected = 0;
			for(int i = 0; i < N; i++) {
				if(v[i]) {
					kcal += ham[i][1];
					isSelected++;
				}				
			}
			if(kcal > L || isSelected == 0) return;
			else {
				taste = 0;
				for(int i =0; i< N; i++) {
					if(v[i]) taste += ham[i][0];
				}
				if(max == taste) {
					result = kcal >= result? result : kcal;
				}
				else if(max < taste) {
					result = kcal;
					max = taste;
				}
				System.out.println(max +" "+ result);
				return;
			}
		}
		v[cnt] = true;
		//kcal += ham[cnt][1];
		sub(cnt+1);

		v[cnt] = false;
		sub(cnt+1);
	}

}
