package BOJ1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R,C, res;
	static char[][] arr;
	static int[] alp = new int[26];
	static boolean[][] v;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로칸
		C = Integer.parseInt(st.nextToken()); // 가로칸
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		v = new boolean[R][C];
		alp[arr[0][0]-65] = 1;
		dfs(0,0,1,v);
		
		System.out.println(res);
		
	}
	
	static int[] dx = {0,0,-1,1}; // 상하좌우
	static int[] dy = {-1,1,0,0};
	private static void dfs(int y, int x, int cnt, boolean[][] v) {
		
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= C || ny >= R || alp[arr[ny][nx]-65] == 1 || v[ny][nx]) {
				res = Math.max(res, cnt);
				continue;
			}

			v[ny][nx] = true;
			alp[arr[ny][nx]-65] = 1;
			dfs(ny,nx,cnt+1, v);
			v[ny][nx] = false;
			alp[arr[ny][nx]-65] = 0;
			
			
		}
	}

}
