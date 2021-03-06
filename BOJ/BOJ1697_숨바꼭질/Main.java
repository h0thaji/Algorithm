package BOJ1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int MAX_RANGE = 100001;
	static int N,K,res;
	static boolean[] v = new boolean[MAX_RANGE];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이 위치 입력
		K = Integer.parseInt(st.nextToken()); // 동생 위치 입력
		
		if(N!=K) bfs(); // 수빈이와 동생 위치가 다를때 bfs 탐색
		
		sb.append(res); // 결과 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N); // 처음시작은 수빈이 위치이므로 N offer
		v[N] = true; // 방문체크
		
		while(!q.isEmpty()) { // 큐가 빌때까지
			int size = q.size(); // q의 사이즈받아서 
			res++; // 이 반복문에 들어왔다는 건 한번 움직인다는 뜻 res++
			
			while(size-->0) { // q size는 같은 레벨의 크기만큼 있기 때문에 while문을 돌면 해당 레벨까지만 돔, 즉 같은 시간에 움직인 곳만 탐색
				int current = q.poll();
				
				int pre = current - 1; // -1 칸
				int next = current + 1; // + 1칸
				int jump = current * 2; // 텔레포트
			
				if(pre == K || next == K || jump == K) return; // 이동한 곳이 수빈이 위치이면 bfs 종료
				
				
				if(pre >= 0 && !v[pre]) { // 인덱스 벗어나지 않고 방문하지않았으면
					q.offer(pre); // offer
					v[pre] = true; // 방문체크
				}
				if(next < MAX_RANGE && !v[next]) {
					q.offer(next);
					v[next] = true;
				}
				if(jump < MAX_RANGE && !v[jump]) {
					q.offer(jump);
					v[jump] = true;
				}
				
			}
			
		}
		
	}
	

}
