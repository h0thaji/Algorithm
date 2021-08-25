package BOJ1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, H, W;
	static int[][] map;
	static boolean[][][] v;
	static Pos START, END;
	static StringBuilder sb = new StringBuilder();
	static class Pos{
		int y;
		int x;
		int horse;
		int cnt;

		public Pos(int y, int x, int hores,int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.horse = hores;
			this.cnt = cnt;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		v = new boolean[H][W][K+1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		START = new Pos(0,0,0,0);
		END = new Pos(H-1,W-1, 0,0);

		sb.append(bfs());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	static int[][] dir1 = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}}; 
	// 1시 2시 , 4시 5시 , 7시 8시, 10시 11시
	// 움직일 방향
	static int[][] dir2 = {{-1,0},{1,0},{0,-1},{0,1}};

	private static int bfs() {
		Queue<Pos> q = new LinkedList<>();		
		q.offer(START);
		v[0][0][0] = true;
		//int k = 0, cnt = 0;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int horse = pos.horse;
			int cnt = pos.cnt;

			if(pos.y == END.y && pos.x == END.x) return cnt;				

			if(pos.horse < K) {
				for (int i = 0; i < 8; i++) {
					int ny = pos.y + dir1[i][0];
					int nx = pos.x + dir1[i][1];					

					if(check(ny,nx))  continue;
					if(!v[ny][nx][horse+1]) {

						v[ny][nx][horse+1] = true; 
						//map[ny][nx] = map[pos.y][pos.x]+1;
						q.offer(new Pos(ny,nx,horse+1,cnt+1));		
					}
				}
				//K--;
			}

			for (int i = 0; i < 4; i++) {
				int ny = pos.y + dir2[i][0];
				int nx = pos.x + dir2[i][1];

				if(check(ny,nx))  continue;
				if(!v[ny][nx][horse]) {

					v[ny][nx][horse] = true; 
					//map[ny][nx] = map[pos.y][pos.x]+1;
					q.offer(new Pos(ny,nx,horse,cnt+1));		
				}
			}	
			//K--;
		}
		return -1;
	}


	private static boolean check(int y, int x) {
		return y < 0 || y >= H || x < 0 || x >= W || map[y][x] == 1;
	}

}
