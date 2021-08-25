package BOJ8958_OX퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < N; t++) {
			String str = br.readLine();
			int cnt = 1, res = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'O') res += cnt++;
				else cnt = 1;
			}
			sb.append(String.format("%d\n", res));
		}
		System.out.println(sb);
	}

}
