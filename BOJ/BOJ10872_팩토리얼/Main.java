package BOJ10872_팩토리얼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, res = 0;
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
		if(cnt == 0) return 1;
		return cnt * dfs(cnt-1);
	}

}
