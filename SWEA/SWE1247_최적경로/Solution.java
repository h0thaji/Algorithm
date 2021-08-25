package SWE1247_최적경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] cus;
	static int[] C , H ;
	static boolean[] v;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= TC; t++) {
			sb.append(String.format("#%d ", t));
			
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			v = new boolean[N];
			cus = new int[N][2];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			C = new int[2];
			H = new int[2];
			
			C[0] = Integer.parseInt(st.nextToken());
			C[1] = Integer.parseInt(st.nextToken());
			H[0] = Integer.parseInt(st.nextToken());
			H[1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 2; j++) {
					cus[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			search(0,C[0],C[1],0);
			sb.append(min+"\n");
		}
		System.out.println(sb);

	}
	
	private static void search(int cnt, int y, int x, int sum) {
		
		if(sum > min) return;
		if(cnt == N) {
			sum += dis(y,x,H[0],H[1]);
			min = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			sum += dis(y,x,cus[i][0],cus[i][1]);
			search(cnt+1,cus[i][0],cus[i][1], sum);
			v[i] = false;
			sum -= dis(y,x,cus[i][0],cus[i][1]);
		}
	}

	private static int dis(int y, int x , int y2, int x2) {
		
		return Math.abs(y-y2) + Math.abs(x-x2);
	}

}
