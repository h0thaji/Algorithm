package BOJ16954_움직이는미로탈출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	static char[][] arr = new char[8][8];
//	static boolean[][] v = new boolean[8][8];
	static Queue<Pos> q = new LinkedList<Pos>();
	
	static class Pos{
		int y,x;

		public Pos(int y, int x) {
			
			this.y = y;
			this.x = x;
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 8; i++) {
			String input = br.readLine();
			arr[i] = input.toCharArray();
		}
		
		bw.write(String.valueOf(bfs()));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[][] dir = {{0,0},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	private static int bfs() {
		
		q.offer(new Pos(7,0));
		int turn = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			turn++;
			while(size-- > 0) {
				
				Pos uk = q.poll();
				
				int y = uk.y;
				int x = uk.x;
				
				if((y == 0 && x == 7) || turn >= 8) return 1;	
				for(int i = 0; i < 9; i++) {
					int ny = y + dir[i][0];
					int nx = x + dir[i][1];
					
					if(check(ny,nx)) continue;
					if(!isWall(ny,nx)) {
						q.offer(new Pos(ny,nx));
					}
				}
			}
			moveWall();
		}
		return 0;
	}
	private static void moveWall() {
		for(int i = 7 ; i > 0 ; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = "........".toCharArray();
		
	}
	private static boolean isWall(int ny, int nx) {
		return ny-1 >= 0 && arr[ny-1][nx] == '#';
	}
	private static boolean check(int y, int x) {
		return y < 0 || y >= 8 || x < 0 || x >=8 || arr[y][x] == '#';
	}

}
