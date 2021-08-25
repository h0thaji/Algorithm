package BOJ7576_토마토;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M, zero = 0;
	static int[][] box;
	static Queue<Point> q = new LinkedList<>();

	static class Point{
		int y,x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) zero++;
				if(box[i][j] == 1) q.offer(new Point(i,j));
			}
		}
		if(zero!= 0) bw.write(String.valueOf(bfs()));
		else  bw.write("0");
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int bfs() {
		
		int res = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Point p = q.poll();
				int y = p.y;
				int x = p.x;

				for (int i = 0; i < 4; i++) {
					int ny = y + dir[i][0];
					int nx = x + dir[i][1];
					
					if(check(ny,nx)) continue;
					if(box[ny][nx] == 0) {
						q.offer(new Point(ny,nx));
						box[ny][nx] = 1;
						zero--;
					}					
				}
			}
			res++;
			
		}
		if(zero != 0) return -1;
		return res-1;
		
	}
	private static boolean check(int y, int x) {
		
		return y < 0 || x < 0 || y >= N || x >= M || box[y][x] == -1 ;
	}

}
