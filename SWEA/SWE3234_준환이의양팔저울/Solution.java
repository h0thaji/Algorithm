package SWE3234_준환이의양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, R, Sum, res;
	static int[] arr, test;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 오른쪽  =< 왼쪽
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			test = new int[N];
			Sum = 0;
			res = 0;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				Sum += arr[i];
			}


			for (int i = 1; i < N; i++) {
				R = i;
				v = new boolean[N];
				per(0,0);
			}
			System.out.println(res);
			res += fac(N);

			sb.append(String.format("#%d %d\n", tc,res));
		}
		System.out.println(sb);

	}

	public static void per(int cnt, int lSum) {

		if(cnt == R) {
			if(Sum - lSum > lSum) return;

			per2(0);
			return;

		}


		for (int i = 0; i < N; i++) {

			if(v[i]) continue;

			v[i] = true;
			//lSum += arr[i];
			per(cnt+1, lSum + arr[i]);
			//lSum -= arr[i];
			v[i] = false;

		}
	}
	public static void per2(int cnt) {

		if(cnt == N - R) {
			for (int i = 0; i < N; i++) {
				if(v[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			res++;
			return;
		}

		for (int i = 0; i < N; i++) {

			if(v[i]) continue;

			v[i] = true;
			per2(cnt+1);

			v[i] = false;

		}
	}

	public static int fac(int n) {
		if(n<=1)
			return n;
		else
			return fac(n-1)*n;
	}

}
