package BOJ1613_역사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, K, S;
	static boolean[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())+1;
		K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true;
		}
		
		//플로이드와샬
		for(int k = 1; k < N; k++) { // k 중간노드
			for(int i = 1; i < N; i++) { // i 시작노드
				for(int j = 1; j < N; j++) { // j 도착노드
					if(arr[i][k] && arr[k][j]) arr[i][j] = true; // i->k->j로 갈 수 있다는 뜻
				}
			}
		}
		
		S = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(arr[a][b] == arr[b][a]) sb.append(0).append("\n"); // 같다면 false, false 경우 밖에 없음. 즉 모른다
			else sb.append(arr[a][b]? -1:1).append("\n"); // 다르다면 [a][b]가 true이면 a가 b로 갈 수 있다는 의미, 즉 a가 순서가 더 빠르므로 -1, false면 [b][a]가 true이므로 1 출력
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
