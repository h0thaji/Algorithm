package SWE2001_파리퇴치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Recusive {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0;
			int max = 0;
			rec(N-M);
			//파리채 도는거
			for(int l = 0; l <= N-M; l++) {
				for(int k = 0; k <= N-M; k++) {
					
					for(int i = l; i < l+M; i++) {					
						for(int j = k; j < k+M; j++) {
							sum+=map[i][j];
						}						
					}
					max = Math.max(max, sum);
					sum = 0;					
				}
			}

			sb.append("#"+t+" "+max+"\n");

		}
		System.out.println(sb);
	}

	private static void rec(int temp) {
		int cnt = 0;
		if(cnt > temp) return;
		
		
		
	}
	
	

}
