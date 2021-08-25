package BOJ10158_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int W, H, y, x, T;
	static int[][] arr;
	static int[][] dir = {{1,1},{-1,1},{-1,-1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken())+1;
		H = Integer.parseInt(st.nextToken())+1;
		arr = new int[W][H];
				
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(br.readLine());
		
		int ny, nx;
		int idx = 0;
		boolean check = false;
		for (int i = 0; i < T; i++) {
			
			ny = y + dir[idx][0];
			nx = x + dir[idx][1];
			
			
			if(nx < 0 || ny < 0 || nx >= H || ny >= W) {
				
				for(int ni = idx; ni < idx+4; ni++ ) {
					
					ny = y+dir[idx][0];
					nx = x+dir[idx][1];
					
				}
				if(!check) {
					idx++;
					if(idx == 2) check = true;
				}else {
					idx--;
					if(idx == 0) check = false;
				}

				
				
			}
			
			y = ny;
			x = nx;
			
		}
		
		System.out.printf("%d %d",y,x);
		
	}

}
