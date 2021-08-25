package BOJ4344_평균은넘겠지;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < C; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			sum = sum/N;
			int nSum = 0;
			for (int i = 0; i < N; i++) {
				if(sum < arr[i]) nSum++;
			}
			sb.append(String.format("%.3f",(double) nSum/N*100));
			sb.append("%\n");
			
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();

	}

}
