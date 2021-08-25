package BOJ14503_로봇청소기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dx = {0, 1, 0 , -1};
	static int[] dy = {-1, 0, 1 , 0};
	static int cnt = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		map[y][x] = 2;
		int nx, ny, nw;
		boolean check;

		while(true) {
			check = false;
			
			for (int i = 0; i < 4; i++) {

				w = (w+3)%4;
				ny = y + dy[w];
				nx = x + dx[w];
				if(ny < N && ny >= 0 && nx < M && nx >= 0 && map[ny][nx] == 0) {
					y = ny;
					x = nx;
					map[y][x] = 2;
					cnt++;
					check = true;
					break;
				}				
			}
			if(check) continue;

			nw = (w+2)%4;
			y = y + dy[nw];
			x = x + dx[nw];

			if(y < 0 || y >= N || x < 0 || x >= M || map[y][x] == 1) break;
			
			
		}

		System.out.println(cnt);
		
	}


}


