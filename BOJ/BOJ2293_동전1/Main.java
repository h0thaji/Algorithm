package BOJ2293_동전1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = coin; j <= K; j++) {
				dp[j] = dp[j] + dp[j-coin];
			}
		}
		
		sb.append(dp[K]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
