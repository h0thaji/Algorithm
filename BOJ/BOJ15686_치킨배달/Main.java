package BOJ15686_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map, ck, h, dis;
	static boolean[] v;
	static int N, M;
	static int hCnt, ckCnt, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		ck = new int[13][2];
		h = new int[2*N][2];
		for (int i = 1; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					h[hCnt][0] = i;
					h[hCnt][1] = j;
					hCnt++;
				}
				else if(map[i][j] ==2) {
					ck[ckCnt][0] = i;
					ck[ckCnt][1] = j;
					ckCnt++;
				}
			}
		}

		disCnt(hCnt, ckCnt); // 각 치킨집과 집의 거리 배열생성
		v = new boolean[ckCnt];
		result = Integer.MAX_VALUE;
		resCnt(0,0);
		System.out.println(result);

	}
	private static void disCnt(int hCnt, int ckCnt) {
		// 각 치킨집과 집의 거리 배열생성
		dis = new int[hCnt][ckCnt];
		for (int i = 0; i < hCnt; i++) {
			for (int j = 0; j < ckCnt; j++) {
				dis[i][j] = Math.abs(h[i][0] - ck[j][0]) + Math.abs(h[i][1] - ck[j][1]); // 순서대로 집과 치킨집의 좌표값을 구해 거리를 계산해서 해당 배열에 넣어줌
			}
		}
	}
	
	private static void resCnt(int cnt, int s) {
		if(cnt == M) {
			int res = 0;
			
			for(int i = 0; i < hCnt; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < ckCnt; j++) {
					if(v[j]) {
						min = Math.min(min, dis[i][j]);
					}
				}
				res += min;
			}
			result = Math.min(res, result);
		}
		for (int i = s; i < ckCnt; i++) {
			v[i] = true;
			resCnt(cnt+1,i+1);
			v[i] = false;
		}
	}
}

