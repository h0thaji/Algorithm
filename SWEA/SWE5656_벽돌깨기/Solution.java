package SWE5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,W,H,brick, res;
	static int[][] arr;
	static int[] marble;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static class Point{
		int y,x,w;

		public Point(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			arr = new int[H][W];
			marble = new int[N];
			res = Integer.MAX_VALUE;
			brick = 0;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]!=0) brick++;
				}
			}
			
			search(0);
			sb.append(res).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

	private static void search(int cnt) {
		if(cnt == N) {
			
			
			res = Math.min(res, breakBrick(new int[H][W]));
			return;
		}
		
		for (int i = 0; i < W; i++) {
			marble[cnt] = i;
			search(cnt+1);
		}
		
	}

	private static int breakBrick(int[][] narr) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				narr[i][j] = arr[i][j];
			}
		}
		int tBrick = brick;
		
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < H; j++) {
				if(narr[j][marble[i]] != 0) {
					q.offer(new Point(j,marble[i],narr[j][marble[i]]));
					tBrick--;
					narr[j][marble[i]] = 0;
					break;
				}
			}
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				int y = p.y;
				int x = p.x;
				int end = p.w;
				
				
				
				for (int j = 0;j < 4; j++) {
					
					for (int w = 1; w < end; w++) {
						int ny = y + dir[j][0] * w;
						int nx = x + dir[j][1] * w;
						
						if(check(ny,nx)) continue;
						if(narr[ny][nx] != 0) {
							q.offer(new Point(ny,nx,narr[ny][nx]));
							tBrick--;
							narr[ny][nx] = 0;
						}
					}
					
				}
			}
			fallBrick(narr);
		}
		
		
		
		return tBrick;
	}

	private static void fallBrick(int[][] narr) {
		for (int j = 0; j < W; j++) {
			for (int i = H-1; i > -1; i--) {
				if(narr[i][j] == 0) {
					int ni = i;
					while(ni > 0 && narr[ni][j] == 0) ni--;
					
					narr[i][j] = narr[ni][j];
					narr[ni][j] = 0;
				}
			}
		}
		
		
	}

	private static boolean check(int y, int x) {
		return y < 0 || x < 0 || y >= H || x >= W;
	}




}
