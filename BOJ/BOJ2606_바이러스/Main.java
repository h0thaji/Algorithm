package BOJ2606_바이러스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, res;
	static boolean[][] adjMatrix;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		L = Integer.parseInt(br.readLine());
		
		adjMatrix = new boolean[N+1][N+1];
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			adjMatrix[n1][n2] = adjMatrix[n2][n1] = true;

		}
		
		bfs();
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		q.offer(1);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			for (int i = c+1; i < N+1; i++) {
				if(adjMatrix[c][i] && !v[i]) {
					q.offer(i);
					v[i] = true;
					res++;
				}
				
			}
		}
	}

}
// 인접리스트, bfs
//public class Main {
//
//	static int N, L, res;
//	static Node[] adjList;
//	
//	static class Node {
//		int vertex;
//		Node next;
//		
//		public Node(int vertex, Node next) {
//			super();
//			this.vertex = vertex;
//			this.next = next;
//		}
//		
//		
//	}
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		
//		
//		N = Integer.parseInt(br.readLine());
//		L = Integer.parseInt(br.readLine());
//		
//		adjList = new Node[N+1];
//		
//		for (int i = 0; i < L; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int n1 = Integer.parseInt(st.nextToken());
//			int n2 = Integer.parseInt(st.nextToken());
//			
//			adjList[n1] = new Node(n2,adjList[n1]);
//			adjList[n2] = new Node(n1,adjList[n2]);
//		}
//		
//		bfs();
//		sb.append(res-1);
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	private static void bfs() {
//		Queue<Integer> q = new LinkedList<>();
//		boolean[] v = new boolean[N+1];
//		q.offer(1);
//		v[1] = true;
//		
//		while(!q.isEmpty()) {
//			int current = q.poll();
//			res++;
//			for (Node tmp = adjList[current]; tmp != null; tmp = tmp.next) {
//				if(!v[tmp.vertex]) {
//					v[tmp.vertex] = true;
//					q.offer(tmp.vertex);
//				}
//			}
//		}
//		
//	}
//
//}
