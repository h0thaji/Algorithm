package BOJ1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) q.add(i);
		
		sb.append("<");
		int cnt = 0;
		while(q.size() > 1) {
			cnt++;
			if(cnt % K == 0) {
				sb.append(q.poll()+", ");
				continue;
			}
		
			q.add(q.poll());
			
		}
		sb.append(q.poll()+">");
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();

	}

}
