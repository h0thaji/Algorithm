package BOJ4963_섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int W, H, res;
	static int[][] arr;
	static int[][] dir = {
			{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1} // 상 부터 시계방향
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			res = 0;
			
			if(W == 0 & H == 0) break;
			
			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(arr[i][j] == 1 ) {
						arr[i][j] = 2;
						dfs(i, j);
						res++;
					}
				}
			}
			
			sb.append(String.format("%d\n", res));
		}
		System.out.println(sb);
		
	}
	public static void dfs(int y, int x) {
		int nx, ny;
		for (int i = 0; i < dir.length; i++) {
			ny = y + dir[i][0];
			nx = x + dir[i][1];
			
			if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
			if(arr[ny][nx] == 2 || arr[ny][nx] == 0) continue;
			
			arr[ny][nx] = 2;
			dfs(ny, nx);
		}
	}
	

}
