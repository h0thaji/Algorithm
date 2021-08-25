package BOJ14502_연구소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,res = 0;
	static int[][] arr, tmp;
	static ArrayList<Pos> virus = new ArrayList<>();
	static ArrayList<Pos> zero = new ArrayList<>();
	static boolean[] v;
	
	static class Pos{
		int y;
		int x;
		
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					virus.add(new Pos(i,j));
				}else if(arr[i][j] == 0) {
					zero.add(new Pos(i,j));
				}
			}
		}
		
		search(0, 0, arr);
				
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int bfs(int cnt,int[][] arr) {
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int y = p.y;
			int x = p.x;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				if(check(ny,nx) || arr[ny][nx] != 0) continue;
				
				arr[ny][nx] = 2;
				cnt++;
				q.offer(new Pos(ny,nx));
				
			}
		}
		return cnt;
	}
	
	private static boolean check(int y, int x) {
		return y < 0 || x < 0 || y>=N || x >= M;
	}
	
	private static void search(int cnt, int start,int[][] arr) {
		if(cnt == 3) {
			int zeroCnt = zero.size() - 3 + virus.size()- bfs(virus.size(),newArray(arr));
			res = Integer.max(res, zeroCnt);
			return;
		}
		
		for (int i = start; i < zero.size(); i++) {
			//if(v[i]) continue;
			Pos z = zero.get(i);
			arr[z.y][z.x] = 1;
			search(cnt+1,i+1,arr);
			arr[z.y][z.x] = 0;
		}
		
	}
	
	private static int[][] newArray(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}

//public class Main {
//
//	static int N,M,res = 0;
//	static int[][] arr, tmp;
//	static ArrayList<Pos> virus = new ArrayList<>();
//	static ArrayList<Pos> wall = new ArrayList<>();
//	static ArrayList<Pos> zero = new ArrayList<>();
//	static boolean[] v;
//	
//	static class Pos{
//		int y;
//		int x;
//		
//		public Pos(int y, int x){
//			this.y = y;
//			this.x = x;
//		}
//	}
//		
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		arr = new int[N][M];
//		
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//				if(arr[i][j] == 2) {
//					virus.add(new Pos(i,j));
//				}else if(arr[i][j] == 0) {
//					zero.add(new Pos(i,j));
//				}
//			}
//		}
//		
//		v = new boolean[zero.size()];
//		search(0, 0);
//		
//		for(int i = 0; i < wall.size(); i+=3) {
//			
//			tmp = new int[N][M];
//			for (int l = 0; l < N; l++) {
//				for (int j = 0; j < M; j++) {
//					tmp[l][j] = arr[l][j];
//				}
//			}		
//			
//			for (int j = 0; j < 3; j++) {
//				int y = wall.get(i+j).y;
//				int x = wall.get(i+j).x;
//				tmp[y][x] = 1;
//			}
//			int zeroCnt = zero.size() - 3 +virus.size()- bfs(virus.size());
//
//			res = Integer.max(res, zeroCnt);
//		}
//		
//		sb.append(res);
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
//	private static int bfs(int cnt) {
//		Queue<Pos> q = new LinkedList<>();
//		for (int i = 0; i < virus.size(); i++) {
//			q.offer(virus.get(i));
//		}
//		
//		while(!q.isEmpty()) {
//			Pos p = q.poll();
//			int y = p.y;
//			int x = p.x;
//			
//			for (int i = 0; i < 4; i++) {
//				int ny = y + dir[i][0];
//				int nx = x + dir[i][1];
//				
//				if(check(ny,nx)) continue;
//				if(tmp[ny][nx] == 0) {
//					tmp[ny][nx] = 2;
//					cnt++;
//					q.offer(new Pos(ny,nx));
//				}
//				
//			}
//		}
//		return cnt;
//	}
//	
//	private static boolean check(int y, int x) {
//		return y < 0 || x < 0 || y>=N || x >= M;
//	}
//	
//	private static void search(int cnt, int start) {
//		if(cnt == 3) {
//			for (int i = 0; i < zero.size(); i++) {
//				if(v[i]) {
//					
//					int y = zero.get(i).y;
//					int x = zero.get(i).x;
//					wall.add(new Pos(y,x));
//				}
//			}
//			return;
//		}
//		
//		for (int i = start; i < zero.size(); i++) {
//			//if(v[i]) continue;
//			v[i] = true;
//			search(cnt+1,i+1);
//			v[i] = false;
//		}
//		
//	}
//
//}
