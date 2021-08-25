package BOJ1806_부분합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,S;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		
		while(true) {
			//System.out.println("start : "+start+" / end : "+end+" / sum : "+sum +" / res : "+res);
			if(sum >= S) {
				res = Math.min(res, (end-start));
				sum -= arr[start++];
					
			}else if(end == N) break;
			else sum+=arr[end++];

			//System.out.println("start : "+start+" / end : "+end+" / sum : "+sum);
		}
		
		sb.append(res==Integer.MAX_VALUE? 0 : res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
