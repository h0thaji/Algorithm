package BOJ1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 크루스칼
// 간선을 하나씩 선택해서 MST를 찾는 알고리즘
//
// 1. 최초, 모든 간선을 가중치에 따라 오름차순으로 정렬
// => 간선정보를 담는 edgeList를 만듬
// => edgeList를 Comparable를 통해 정렬
//
// 2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시킴
// => 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택 
// => 간선을 선택한다는 것은 두 정점을 잇는 다는 말(w의 비용)
//
// 3. V-1 개의 간선이 선택될 때까지 2번을 반복
public class Main {

	static int V,E;
	static int[] parents;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int from, to, w;
		
		
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {			
			return Integer.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		//edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(from,to,w));
		}
		
		//Arrays.sort(edgeList);
		
		makeSet();
		int res = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(union(e.from,e.to)) {
				res += e.w;
				if(++cnt == V-1) break;
			}
		}
		
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void makeSet() {
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
		
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
//public class Main {
//
//	static int V,E;
//	static int[] parents;
//	static Edge[] edgeList;
//	static PriorityQueue<Edge> pq = new PriorityQueue<>();
//	static class Edge implements Comparable<Edge>{
//		int from, to, w;
//		
//		
//		public Edge(int from, int to, int w) {
//			super();
//			this.from = from;
//			this.to = to;
//			this.w = w;
//		}
//		
//		@Override
//		public int compareTo(Edge o) {			
//			return Integer.compare(this.w, o.w);
//		}
//		
//	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//			
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		
//		parents = new int[V+1];
//		edgeList = new Edge[E];
//		
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			
//			edgeList[i] = new Edge(from,to,w);
//		}
//		
//		Arrays.sort(edgeList);
//		
//		makeSet();
//		int res = 0;
//		int cnt = 0;
//		
//		for (Edge e : edgeList) {
//			if(union(e.from,e.to)) {
//				res += e.w;
//				if(++cnt == V-1) break;
//			}
//		}
//		
//		sb.append(res);
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	
//	private static void makeSet() {
//		for (int i = 1; i < V+1; i++) {
//			parents[i] = i;
//		}
//		
//	}
//	
//	private static boolean union(int a, int b) {
//		int aRoot = findSet(a);
//		int bRoot = findSet(b);
//		if(aRoot == bRoot) return false;
//		
//		parents[bRoot] = aRoot;
//		return true;
//	}
//
//	private static int findSet(int a) {
//		if(parents[a] == a) return a;
//		return parents[a] = findSet(parents[a]);
//	}
//
//}
