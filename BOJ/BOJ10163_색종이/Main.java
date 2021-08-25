package BOJ10163_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] arr = new boolean[101][101];
	static int[][] dir ;
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		dir = new int[N+1][4];
		res = new int[N];
		
		for (int t = 1; t <= N; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < 4; i++) {
				
				dir[t][i] = Integer.parseInt(st.nextToken());
				
				if(i == 2) dir[t][i] += dir[t][0];
				else if(i == 3) dir[t][i] += dir[t][1];
			}			
		}
		
		
		for(int n = N; n >= 1 ; n--) {

			for (int i = dir[n][0]; i < dir[n][2]; i++) {
				for (int j = dir[n][1]; j < dir[n][3]; j++) {
					
					if(arr[i][j]) continue;
					arr[i][j] = true;
					res[n-1]++;
				}
			}			
		}
		
		for (int a : res) System.out.println(a);

	}

}
