package BOJ14500_테트로미노;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M,res;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				tetromino_IZOL(i,j,0,0);
				tetromino_T(i,j);
				
			}
		}
		System.out.println(res);
	}

	private static void tetromino_T(int y, int x) {
		
		int sum = map[y][x];
		int isT = 4;
		int min = 1001;
		
		for(int i = 0; i < 4; i++) {
			
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if(isT <= 2) {
				return;
			}
			
			if(check(ny,nx)) {
				isT--;
				continue;
			}
			min = Integer.min(min, map[ny][nx]);
			sum += map[ny][nx];
		}
		
		if(isT == 4) {
			sum -= min;
		}
		
		res = Integer.max(res, sum);
		
	}

	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static void tetromino_IZOL(int y, int x,int cnt,int sum) {
		if(cnt == 4) {
			res = Integer.max(res,sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if(check(ny,nx)) continue;
			if(v[ny][nx]) continue;
			
			v[ny][nx] = true;
			tetromino_IZOL(ny,nx,cnt+1,sum+map[ny][nx]);
			v[ny][nx] = false;
		}

	}

	private static boolean check(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= M;
	}
	

}
