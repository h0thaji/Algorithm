package BOJ2916_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, result;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		sub(1<<N);
		System.out.println(result);

	}
	private static void sub(int cnt) {
		
		for(int i = 1; i < cnt; i++) {
			int s = 1;
			int t = 0;
			for (int j = 0; j < N; j++) {
				if((i & 1<< j) != 0) {
					s *= arr[j][0];
					t += arr[j][1];
				}				
			}			
			int tmp = Math.abs(s-t);
			result = Math.min(result, tmp);
		}
	}

}
