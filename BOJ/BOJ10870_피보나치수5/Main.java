package BOJ10870_피보나치수5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(dfs(N)));
		bw.flush();
		bw.close();
		br.close();

	}
	private static int dfs(int cnt) {
		if(cnt == 0) return 0;
		if(cnt == 1) return 1;
		return dfs(cnt-1) + dfs(cnt-2);
	}

}
