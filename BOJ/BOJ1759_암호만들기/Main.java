package BOJ1759_암호만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, R;
	static char[] arr, selected;
	static boolean[] v;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {


		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new char[N];
		selected = new char[R];
		v = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		dfs(0, 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int cnt, int s) {

		if(cnt == R ) {
			boolean vowel = false;
			int cons = 0;
			for (int i = 0; i < R; i++) {
				if(selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o' || selected[i] == 'u') {
					vowel = true;
				}else cons++;
			}
			
			if(vowel && cons >=2) {
				for (int i = 0; i < R; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = s; i < N; i++) {
			
			selected[cnt] = arr[i];
			dfs(cnt+1, i+1);
		}
	}

}
