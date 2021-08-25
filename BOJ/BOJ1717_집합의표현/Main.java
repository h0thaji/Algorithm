package BOJ1717_집합의표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		//makeSet
		for(int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		// M 만큼 반복
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st.nextToken()); // 입력키
			int a = Integer.parseInt(st.nextToken()); // a
			int b = Integer.parseInt(st.nextToken()); // b
			if(cal == 0) { // 0이면 합집합
				union(a,b);
			}else { // 1이면 같은집합인지 확인
				sb.append(find(a)==find(b)? "YES":"NO").append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
	private static int find(int a) {
		if(a == arr[a]) return a;
		return arr[a] = find(arr[a]);
		
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) arr[bRoot] = aRoot;
		
	}

}
