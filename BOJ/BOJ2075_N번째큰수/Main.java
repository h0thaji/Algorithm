package BOJ2075_N번째큰수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N*N];
		//N *= N;
		for (int i = 0, idx = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(num);
		
		sb.append(num[N*N - N]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
