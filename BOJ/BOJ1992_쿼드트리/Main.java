package BOJ1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N, res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		divide(0,0,N);
		System.out.println(sb);
	}

	private static boolean check(int y, int x, int n) {
		int first = arr[y][x];
		for(int i = y ; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if(first != arr[i][j]) return false;
			}
		}
		res = first;
		return true;
	}
	
	private static void divide(int y, int x, int n) {
		if(check(y,x,n)) {
			sb.append(res);
		}else {
			sb.append("(");
			int dn = n /2 ;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(y + dn *i, x + dn * j , dn);
				}
			}
			sb.append(")");
		}
	}
}
