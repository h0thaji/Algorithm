package BOJ2567_색종이2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int res;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[100][100];

		st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());// 색종이수
		for (int t = 0; t < N; t++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					if(arr[i][j] == 1) continue;
					arr[i][j] = 1;
				}
			}
	
		}
		int nx , ny;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						nx = j + dx[k];
						ny = i + dy[k];
						if((nx == 100 || ny== 100) ||(nx < 100 && ny < 100 && arr[ny][nx] == 0)) res++;
					}
				}
			}
		}
		System.out.println(res);

	}

}
