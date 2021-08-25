package BOJ3985_롤케이크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int L, N;
	static int[] res = new int[2];
	static boolean[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		L = Integer.parseInt(br.readLine());
		arr = new boolean[L+1];
		
		N = Integer.parseInt(br.readLine());
		
		int max = 0;
		int tmp = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int sub = K - P +1;
			if(max < sub) {
				max = sub;
				res[0] = i;
			}
			
			int cnt = 0;
			
			for (int j = P; j <= K; j++) {
				if(arr[j]) continue;
				arr[j] = true;
				cnt++;
			}
			
			if(tmp < cnt) {
				tmp = cnt;
				res[1] = i;
			}
			
		}
		for (int a : res) {
			System.out.println(a);
		}
	}

}
