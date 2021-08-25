package BOJ9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static Pos[] p;
	static Node[] adjList;

	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
	}
	
	static class Pos{
		int y;
		int x;
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			p = new Pos[N+2];
			adjList = new Node[N+2];

			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				p[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}

			Pos n1, n2;
			for (int i = 0; i < N+2; i++) {
				n1 = p[i];
				for (int j = i+1; j < N+2; j++) {
					n2 = p[j];
					int dis = Math.abs(n1.y-n2.y)+Math.abs(n1.x-n2.x);
					if(dis <= 1000) {
						adjList[i] = new Node(j,adjList[i]);
						adjList[j] = new Node(i,adjList[j]);
					}
				}
			}
			
			if(bfs()) sb.append("happy\n");
			else sb.append("sad\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+2];
		q.offer(0);
		v[0] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (Node tmp = adjList[current]; tmp != null; tmp = tmp.next) {
				if(!v[tmp.vertex]) {
					q.offer(tmp.vertex);
					v[tmp.vertex] = true;
				}
			}
		}
		return v[N+1];
	}

}
