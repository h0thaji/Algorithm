package BOJ2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[100][100];
		int result = 0;
		int p = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < p; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					if(i  > 99 || j > 99) continue;
					map[i][j] = 1;
				}
			}			
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result);
	}

}
