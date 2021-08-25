package BOJ16926_배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 메모리 최적화 시키기
	
	static int[] dx = {0,1,0,-1}; //하우상좌
	static int[] dy = {1,0,-1,0};
	static int mx,my;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작지점옮기는 것은  Min(n,m) /2 -1 까지 => 수행횟수 , 0부터시작
		// 상하는 N - 1 번 후 -2 씩 해줌, 좌우는 M-1 번후 -2
		

		while(R-- >0) {
			
			Queue<Integer> q = new LinkedList<>();
			int cnt = Math.min(N, M) / 2 ;
			mx = M -1;
			my = N -1;
			int x = 0,y = 0;
			int nx = 0,ny = 0;
			
			while(cnt-- >0) {
				q.offer(arr[ny][nx]);
				for (int i = 0; i < 4; i++) {

					switch(i) {
					case 0:
						for (int j = 0; j < my; j++) {
							ny = ny + dy[i];
							q.offer(arr[ny][nx]);
							arr[ny][nx] = q.poll();
						}
						break;
					case 1:
						for (int j = 0; j < mx; j++) {
							nx = nx + dx[i];
							q.offer(arr[ny][nx]);
							arr[ny][nx] = q.poll();
						}
						break;
					case 2:
						for (int j = 0; j < my; j++) {
							ny = ny + dy[i];
							q.offer(arr[ny][nx]);
							arr[ny][nx] = q.poll();
						}
						break;
					case 3:
						for (int j = 0; j < mx; j++) {
							nx = nx + dx[i];
							q.offer(arr[ny][nx]);
							arr[ny][nx] = q.poll();
						}
						break;
					}

				}
				ny++;
				nx++;
				mx -= 2;
				my -= 2;
				q.clear();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
