package BOJ13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, res = 0;
	static boolean[] v = new boolean[100001];
	
	static public class Pos{
		int x, w;
		
		public Pos(int x, int w) {
			this.x = x;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) res = 0;
		else if( N > K) res = N - K;
		else res = bfs();

		
		System.out.println(res);

	}
	static int[] dir = {-1,1};
	private static int bfs() {
		int min = Integer.MAX_VALUE;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(N,0));
		//v[N] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int x = p.x;
			int sec = p.w;
			if(x == K) min = Math.min(min, sec);
			v[x] = true;
					
			for(int i = 0; i < 2; i++) {
				int nx = x + dir[i];
				
				if(check(nx)) continue;
				if(v[nx]) continue;
				
				q.offer(new Pos(nx,sec+1));
				//v[nx] = true;
			}
			int teleport = x * 2;
			if(!check(teleport)) q.offer(new Pos(teleport, sec));
			
			
		}
		return min;
	}
	private static boolean check(int x) {
		return x < 0 || x >= 100000;
	}

}
