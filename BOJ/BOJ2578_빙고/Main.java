package BOJ2578_빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, res;
	static int[][] arr = new int [5][5];

	static int[][] dir = {{1,0},{0,1},{1,1},{1,-1}}; // 상 부터 시계방향
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				res = 0;
				cnt++;
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
						if(arr[y][x] == num) arr[y][x] = 0;
					}
				}
				
				if(search()) {
					System.out.println(cnt);
					return;
				}
				
			}
			
			
			
			
		}
	}
	public static boolean search() {
		int cnt;
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(arr[i][j] != 0) break;
				cnt++;
			}
			if(cnt == 5) res++;
		}
		
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(arr[j][i] != 0) break;
				cnt++;
			}
			if(cnt == 5) res++;
		}
		
		cnt = 0;
		for (int i = 0, j = 0; i < 5; j++, i++) {
			if(arr[j][i] != 0) break;
			cnt++;
		}
		if(cnt == 5) res++;
		
		cnt = 0;
		for (int i = 4, j = 0; i >= 0; j++, i--) {
			if(arr[j][i] != 0) break;
			cnt++;
		}
		if(cnt == 5) res++;
		if(res >= 3) return true;
		
		return false;
	}

}
