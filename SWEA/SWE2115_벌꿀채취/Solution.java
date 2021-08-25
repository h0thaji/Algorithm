package SWE2115_벌꿀채취;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, C;
	static int[][] map;
	static boolean[][] v;
	static int aMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				int start = 0;
				int end = M;
				
				while(end < N) {
					dfs(i,start,end,0,new boolean[N]);
				}
			}
		}
		
		
	}
	private static void dfs(int i,int start, int end, int sum, boolean[] h) {
		if(start < end) {
			if(sum <= C) {
				aMax = Math.max(aMax, sum);
				return;
			}
		}
		
		h[start] = true;
		sum += map[i][start];
		dfs(i,start+1,end,sum,h);
		
		h[start] = false;
		sum -= map[i][start];
		dfs(i,start+1,end,sum,h);
	}

}
