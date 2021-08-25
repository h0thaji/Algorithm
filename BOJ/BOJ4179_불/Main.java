package BOJ4179_불;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C;
	static char[][] maze;
	static Point jihoon;
	static Queue<Point> q = new LinkedList<>();
	static boolean[][][] v;
	static class Point{
		int y, x;
		boolean k;

		public Point(int y, int x, boolean k) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];
		v = new boolean[R][C][2];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if(input.charAt(j) == 'J') {
					jihoon = new Point(i,j,true);
					maze[i][j] = '.';
					v[i][j][0] = true;
				}else if(input.charAt(j) == 'F') {
					q.offer(new Point(i,j,false));
					maze[i][j] = input.charAt(j);
					v[i][j][1] = true;
				}
				else maze[i][j] = input.charAt(j);
				
			}

		}
		int res = bfs();
		if(res == -1) sb.append("IMPOSSIBLE");
		else sb.append(res);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int bfs() {
		q.offer(jihoon);
		int cnt =0;
		while(!q.isEmpty()) {				
			int size = q.size();
			
			while(size-- > 0) {
				Point p = q.poll();
				int y = p.y;
				int x = p.x;
				boolean isJ = p.k;
				
				for (int i = 0; i < 4; i++) {
					int ny = y + dir[i][0];
					int nx = x + dir[i][1];
					
					if(check(ny,nx)) {
						if(isJ) return cnt+1;
						continue;
					}					
					if(maze[ny][nx] == '.') {
						
						if(!isJ && !v[ny][nx][1]) {
							maze[ny][nx] = 'F';
							v[ny][nx][1] = true;
							q.offer(new Point(ny,nx,isJ));
						}
						
						else if(isJ && !v[ny][nx][0]) {
							v[ny][nx][0] = true;
							q.offer(new Point(ny,nx,isJ));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	private static boolean check(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

}
