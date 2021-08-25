package BOJ12851_숨바꼭질2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,K,cnt,cases;
	static boolean[] v = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N != K) bfs();
		sb.append(cnt).append("\n").append(cases);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.clear();
		cnt = 0;
		
		v[N] = false;
		q.offer(N);
		v[N] = true;
		
		casefor : while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				int n = q.poll();
				
				if(n == K) {
					bfs(); 
					break casefor;
				}
				
				int pre = n-1;
				int next = n+1;
				int jump = n*2;
				
				if(pre >= 0 && !v[pre]) {
					v[pre] = true;
					q.offer(pre);
				}
				if(next < 100000 && !v[next]) {
					v[next] = true;
					q.offer(next);
				}
				if(jump < 100000 && !v[jump]) {
					v[jump] = true;
					q.offer(jump);
				}
			}
			cnt++;
			
		}
		return;
		
	}


}
