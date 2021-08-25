package SWE7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, res;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr= new int[N+1];
			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}

			res = 0;
			for (int i = 1; i < N+1; i++) {
				findCompany(i);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	private static void findCompany(int a) {
		if(arr[a] == a) res++;
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
	private static void make() {
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
	}
	

}
