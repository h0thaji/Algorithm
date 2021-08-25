package SWE1868_파핑파핑지뢰찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int T, N, res, clean;
	static int[][] arr;
	static boolean[][] v;
	static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static Queue<Point> q = new LinkedList<>();
	
	static class Point{
		int y,x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}


	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();


		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			v = new boolean[N][N];
			q.clear();
			res = 0;
			clean = 0;
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.charAt(j);					
					if(arr[i][j] == '.') clean++;

				}
			}
			
			searchZero();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 0 && !v[i][j]) {
						
						q.offer(new Point(i,j));
						v[i][j] = true;
						bfs();
						clean--;
						res++;
						
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res+clean).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();


	}
	
	private static void searchZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == '.') {
					int mine = 0;
					for (int d = 0; d < 8; d++) {
						int ny = i + dir[d][0];
						int nx = j + dir[d][1];
						
						if(check(ny,nx)) continue;
						if(arr[ny][nx] == '*') mine++;
					}
					arr[i][j] = mine;

				}

			}
		}
		
	}

	
	private static void bfs() {
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int y = p.y;
			int x = p.x;

			for (int i = 0; i < 8; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				if(check(ny,nx)) continue;
				if(arr[ny][nx] != '*' && !v[ny][nx]) {
					v[ny][nx] = true;
					if(arr[ny][nx] == 0) q.offer(new Point(ny,nx));
					clean--;
				}
			}
			
			
			
		}
		

	}
	private static boolean check(int y, int x) {
		return y < 0|| x < 0 || y >= N || x >= N;
	}
	

}
