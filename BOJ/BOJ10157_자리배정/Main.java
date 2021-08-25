package BOJ10157_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int Y,X,K;
	static int[][] arr;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 우하좌상
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken())+1;
		X = Integer.parseInt(st.nextToken())+1;
		
		arr = new int[Y][X];
		
		K = Integer.parseInt(br.readLine());
		
		int ny, nx;
		int y = 1, x = 1, idx = 0, cnt = 1;
		
		if(K > (Y-1)*(X-1)) {
			System.out.println(0);
			return;
		}
		while(true) {
			
			arr[y][x] = cnt++;
			if(arr[y][x] == K) {
				System.out.printf("%d %d",y ,x);
				break;
			}
			ny = y + dir[idx][0];
			nx = x + dir[idx][1];
			
			if(ny < 1 || nx < 1 || ny >= Y || nx >= X || arr[ny][nx] != 0) {
				idx = (idx+1) % 4;
				ny = y + dir[idx][0];
				nx = x + dir[idx][1];
			}
			
			y = ny;
			x= nx;
			
		}
		

	}

}
