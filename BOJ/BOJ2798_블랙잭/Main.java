package BOJ2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, tmp = Integer.MAX_VALUE, res;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		com(0,0,0);
		System.out.println(res);

	}
	public static void com(int cnt, int s, int sum) {
		if(sum > M) return;
		
		if(cnt == 3) {
			int num = N - sum;
			if(tmp > num) {
				tmp = num;
				res = sum;
			}
			return;
		}
		for (int i = s; i < N; i++) {
			com(cnt+1, i+1, sum+arr[i]);
		}
	}

}
