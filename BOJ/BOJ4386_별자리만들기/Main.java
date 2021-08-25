package BOJ4386_별자리만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, V;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static ArrayList<Pos> star = new ArrayList<>();
	static int[] parents;
	static class Edge implements Comparable<Edge>{

		int from,to;
		double w;
				
		public Edge(int from, int to, double w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}


		public int compareTo(Edge o) {			
			if(this.w > o.w) return 1;
			else if(this.w < o.w) return -1;		
			return 0;
		}
		
	}
	
	static class Pos{
		double y;
		double x;
		
		public Pos(double y, double x) {
			this.y = y;
			this.x = x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double y = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			
			star.add(new Pos(y,x));
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				Pos from = star.get(i);
				Pos to = star.get(j);
				double w =Math.sqrt(Math.pow(Math.abs(from.y-to.y),2) + Math.pow(Math.abs((from.x-to.x)),2));
				pq.add(new Edge(i,j,w));
			}
		}
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		int cnt = 0;
		double res = 0;
		
		while(!pq.isEmpty()) {
			Edge e= pq.poll();
			if(union(e.from,e.to)) {
				res += e.w;
				if(++cnt == N-1) break;
			}
		}
		sb.append(Math.round((res) * 100) /100.0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

}
