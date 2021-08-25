package BOJ2999_비밀이메일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, R, C;
	static char[][] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		N = str.length();
		C = N;
		for (int i = 1; i < C; i++) {
			if(N % i == 0) {
				C = N /i;
				R = i;
			}
		}

		res = new char[R][C];
		int idx = 0;
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				res[j][i] = str.charAt(idx++);
			}
		}

		for(char[] c : res) {
			sb.append(c);
		}
		System.out.println(sb);
	}

}
