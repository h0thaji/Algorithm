package BOJ2447_별찍기10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static boolean[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		
		star(0,0,N);
		
		for(boolean[] a : map) {
			for(boolean b: a) {
				if(b) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	private static void star(int y, int x, int n) {
		
		if(n == 1) {
			map[y][x] = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i == 1 && j == 1))
					star(y + i * (n / 3), x + j * (n / 3), n/3);
			}
		}
		
	}

}
