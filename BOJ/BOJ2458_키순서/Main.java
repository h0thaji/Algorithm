package BOJ2458_키순서;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static Node[] adjList;
	static int[][] who;
	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		who = new int[N+1][2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a] = new Node(b,adjList[a]);
		}
		
		
		bfs();
		sb.append(isKnow());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static int isKnow() {
		int cnt = 0;
		for (int[] a : who) {
			cnt += (a[0] + a[1]) == N - 1? 1 : 0;
		}
		
		return cnt;
		
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i < N+1; i++) {
			boolean[] v = new boolean[N+1];
			q.clear();
			q.offer(i);
			v[i] = true;
			while(!q.isEmpty()) {
				int n = q.poll();
				for (Node tmp = adjList[n]; tmp != null; tmp = tmp.next) {
						if(!v[tmp.vertex]) {
							q.offer(tmp.vertex);
							who[i][0]++;
							who[tmp.vertex][1]++;
							v[tmp.vertex] = true;
						}
						
					
				}
			}
		}
		
	}

}
