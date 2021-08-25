package BOJ2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, danji =1;
	static int[][] arr;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 1) { // 단지수
					arr[i][j] += danji;
					dfs(i,j);
					danji++;
				}

			}
		}
		res = new int[danji-1];

		count();
		System.out.println(sb);


	}

	static int[][] dir = {
			{-1,0},{1,0},{0,-1},{0,1} // 상하좌우
	};
	private static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];

			if(check(ny,nx) || arr[ny][nx] != 1) continue;

			arr[ny][nx] += danji;
			dfs(ny,nx);
		}

		return;

	}

	private static boolean check(int y, int x) {
		return (y < 0 || y >= N || x < 0 || x >=N) ;
	}

	private static void count() {
		
		for (int l = 0; l < res.length; l++) {
			int c = l+2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == c) {
						res[l]++;
					}				
				}
			}
		}
		
		Arrays.sort(res);
		sb.append(danji-1).append("\n");
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i]).append("\n");
		}
	}
}
