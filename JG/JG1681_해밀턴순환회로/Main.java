package JG1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, res, sum;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			v = new boolean[N];
			sum = 0;
			if(arr[0][i] != 0) {
				dfs(0,i,1);
			}
			
		}
		sb.append(res);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void dfs(int x, int y, int cnt) {
		if(sum > res) return;
		sum += arr[x][y];
		v[x] = true;
		if(cnt==N-1) {
			sum += arr[y][0];
			if(arr[y][0] == 0) return;
			res = Math.min(res, sum);
			sum -= arr[y][0];
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!v[i] && arr[y][i] != 0 && sum < res) {
				dfs(y,i,cnt+1);
				sum -= arr[y][i];
				v[i] = false;
			}
		}
		
	}

}
