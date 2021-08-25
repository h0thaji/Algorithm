package SWE3289_서로소집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, T;
	static int[] arr;
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
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				switch(Integer.parseInt(st.nextToken())) {
				case 0:
					union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
					break;
				case 1:
					int a = findSet(Integer.parseInt(st.nextToken()));
					int b = findSet(Integer.parseInt(st.nextToken()));
					if(a==b) sb.append(1);
					else sb.append(0);
					break;
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}
	private static int findSet(int a) {
		if(arr[a] == a) return a;
		return arr[a] = findSet(arr[a]);
		
	}
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(!(aRoot == bRoot)) arr[bRoot] = aRoot;
	
	}

}
