package SWE1249_보급로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, res;
	static int[][] map;
	static boolean[][] v;
	static class Node implements Comparable<Node> {
		int y,x,w;

		public Node(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.w - o.w;
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
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];

			res = 0;
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) -'0';
				}
				
			}
			
			bfs();
			sb.append(res).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int y = n.y;
			int x = n.x;
			int w = n.w;
			
			if(y == N-1 && x == N-1) {
				res = w;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				if(check(ny,nx)) continue;
				if(!v[ny][nx]) {
					pq.offer(new Node(ny,nx,w+map[ny][nx]));
					v[ny][nx]= true;				
				}
			}
		}
	}
	private static boolean check(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

}
