package SWE1220_Magnetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		
		for (int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int x = 0; x < N ; x++) {
				
				boolean check = false;
				
				for(int y = 0; y < N ; y++) {
					if(arr[y][x] == 1) check = true;
					else if(check && arr[y][x] == 2) {
						result++;
						check = false;
					}
					
				}
			}
			sb.append(String.format("#%d %d\n", t,result));
		}

		System.out.println(sb);


	}

}

