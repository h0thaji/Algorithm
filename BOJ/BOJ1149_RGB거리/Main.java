package BOJ1149_RGB거리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, res;
	static int[][] RGB, D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		D = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 3; i++) {
			D[0][i] = RGB[0][i];
		}
		
		res = Math.min(dp(N-1, 0), Math.min(dp(N-1, 1), dp(N-1, 2)));
		
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dp(int n, int c) {
		
		if(D[n][c] == 0) {
			if(c == 0) D[n][c] = Math.min(dp(n-1,1),dp(n-1,2))+ RGB[n][0];
			else if(c == 1) D[n][c] = Math.min(dp(n-1,0),dp(n-1,2))+ RGB[n][1];
			else D[n][c] = Math.min(dp(n-1,0),dp(n-1,1))+ RGB[n][2];
		}
		
		return D[n][c];
	}
}
