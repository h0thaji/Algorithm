package SWE1861_정사각형방;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Solution {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] sort, map;
	static int N, x,y;
	static int max;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			sort = new int[N*N+1][3];
		
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] =	Integer.parseInt(st.nextToken());
						sort[map[i][j]][0] = i;
						sort[map[i][j]][1] = j;

				}
			}

			int cnt;
			for (int i = 1; i < sort.length; i++) {
				
				x = sort[i][1];
				y = sort[i][0];

				cnt = search(x,y,1);

				if(max < cnt) {
					result = i;
					max = cnt;
				}			
			}
			sb.append("#"+t+" "+result+" "+max+"\n");
						
		}
		System.out.println(sb);
		br.close();
	}
//	public static void search2(int x, int y, int cnt) {
//
//		
//		
//	}
	public static int search(int x, int y, int cnt) {
		if(y-1 >=0 && map[y][x] - map[y-1][x] == -1) {
			cnt++;
			return search(x, y-1, cnt);			
		}
		if(y+1 < N && map[y][x] - map[y+1][x] == -1) {
			cnt++;
			return search(x, y+1, cnt);
		}
		if(x-1 >=0 && map[y][x] - map[y][x-1] == -1) {
			cnt++;
			return search(x-1, y, cnt);
		}
		if(x+1 < N && map[y][x] - map[y][x+1] == -1) {
			cnt++;
			return search(x+1, y, cnt);
		}

		return cnt;
		
	}

}
