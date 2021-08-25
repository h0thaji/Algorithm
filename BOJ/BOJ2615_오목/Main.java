package BOJ2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int N = 20;
	static int[][] arr = new int[N][N];
	static int[][] dir = {{-1,1},{0,1},{1,1},{1,0}}; // 오른대각선 위 , 오른쪽 , 오른대각선 밑 , 밑

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		for (int x = 1; x < N; x++) { // 1부터 시작하는 배열
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y < N; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x < N; x++) {
			for (int y = 1; y < N; y++) {
				if(arr[x][y] != 0) {
					// 시작지점인지 확인
					// 탐색하려는 방향 반대방향들을 탐색
					for (int d = 0; d < 4; d++) {

						int nx = x - dir[d][0];
						int ny = y - dir[d][1];

						if((nx >=1 && nx < 20 && ny >= 1 && ny < 20) && arr[x][y] == arr[nx][ny]) continue; // 범위안에 있고 같은 바둑알이 있으면 시작지점이 아니니 패스
						//시작 지점이면
						int res = go(x,y,d);
						
						if(res == 5) { // 시작지점이고 바둑알 5개면													
						System.out.printf("%d\n%d %d",arr[x][y], x,y);
							return;
						}

					}
				}
			}
		}		
		System.out.println(0);
	}


	private static int go(int x, int y, int d) {

		 for (int cnt = 0;; cnt++) {
		        int nx = x + dir[d][0] * cnt;
		        int ny = y + dir[d][1] * cnt;
		      
		        if (!(nx >=1 && nx < 20 && ny >= 1 && ny < 20) || arr[x][y] != arr[nx][ny]) return cnt;
		    }

	}
	

}
