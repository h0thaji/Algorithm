package BOJ14938_서강그라운드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,R;
	static int[] item;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		item = new int[N];
		map = new int[N][N];
		for (int[] a : map) {
			Arrays.fill(a,16);
		}
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = w;
		}

		int res = 0;
		for (int k = 0; k < N ; k++) {
			for (int i = 0; i < N; i++) {
				if(i == k) continue;
				for (int j = 0; j < N; j++) {
					if(j==i) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int sum = item[i];
			for (int j = 0; j < N; j++) {
				if(i!=j && map[i][j] <= M) {
					sum += item[j];
				}
					
			}
			res = Math.max(sum, res);
		}

		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

}
