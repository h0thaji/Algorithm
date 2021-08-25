package BOJ20299_3대측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, L, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 버퍼리더 생성
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; // 토큰 생성 위함
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 팀원 세명 합
		L = Integer.parseInt(st.nextToken()); // 개인 레이팅
		
		for (int tc = 0; tc < N; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());	
			int c = Integer.parseInt(st.nextToken());
			
			if( a >= L && b >= L && c >= L && a+b+c >= K){
				cnt++;
				sb.append(String.format("%d %d %d ", a,b,c));
			}
			
			
		}
		System.out.println(cnt);
		System.out.print(sb);
		
	}

}
