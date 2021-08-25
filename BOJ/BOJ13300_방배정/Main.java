package BOJ13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, res;
	static int[][] student;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		student = new int[2][7];
		check = new boolean[2][7];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			student[S][Y]++;
			if(!check[S][Y]) {
				check[S][Y] = true;
				res++;
			}
			else if(check[S][Y] && student[S][Y] == K) {
				check[S][Y] = false;
				student[S][Y] = 0;
			}
		}

		System.out.println(res);
	}

}
