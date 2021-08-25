package BOJ14889_스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, res = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		v[0] = true;
		dfs(0, 1);
		
		System.out.println(res);
	}
	private static void dfs(int cnt, int s) {
		if(cnt == N/2-1) {
//			for (int i = 0; i < N; i++) {
//				if(v[i]) System.out.print(i+" ");
//			}
//			System.out.println();
			if(res == 0) return;
			int startSum = 0;
			int linkSum = 0;
			int tmp;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					//if(i == j) continue;
					if(v[i] && v[j]) {
						startSum+= arr[i][j]+arr[j][i];
					}
					else if(!v[i] && !v[j]) {
						linkSum+= arr[i][j] + arr[j][i];
					}
				}				
			}
			//System.out.println(startSum +" " +linkSum);
			tmp = Math.abs(startSum - linkSum);
			res = Math.min(tmp, res);
			return;
		}
		
		for (int i = s; i < N; i++) {
						
			v[i] = true;
			dfs(cnt+1, i+1);
			v[i] = false;
			
		}
		
		
	}

}
