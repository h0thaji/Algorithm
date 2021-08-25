package BOJ2846_오르막길;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int pre = Integer.parseInt(st.nextToken());
		int next = 0;
		int cnt = 0;
		int res = 0;
		for (int i = 1; i < N; i++) {
			next = Integer.parseInt(st.nextToken());
			
			if(pre < next) {
				cnt += next - pre;
				res = Math.max(cnt, res);
			}else {
				
				cnt = 0;
			}
			
			pre = next;
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();

	}

}
