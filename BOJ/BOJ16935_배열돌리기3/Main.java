package BOJ16935_배열돌리기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				arr1();
				break;
			case 2:
				arr2();
				break;
			case 3:
				arr3();
				break;
			case 4:
				arr4();
				break;
			case 5:
				arr5();
				break;
			case 6:
				arr6();
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(String.format("%d ", arr[i][j]));	
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	public static void arr1(){
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) q.add(arr[i][j]);
		}

		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = q.poll();
			}
		}
	}

	public static void arr2() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) q.add(arr[j][i]);
		}

		for (int i = M-1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				arr[j][i] = q.poll();
			}
		}
	}

	public static void arr3() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = N-1 ; j >=0; j--) {
				q.add(arr[j][i]);
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = q.poll();
			}
		}


	}
	public static void arr4() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = M-1; i >= 0; i--) {
			for (int j = 0 ; j < N; j++) {
				q.add(arr[j][i]);
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = q.poll();
			}
		}		
	}

	public static void arr5() {
		Queue<Integer> q = new LinkedList<>();
		int x =0,y=0,dx=0,dy=0;
		for(int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				q.add(arr[i][j]);
			}
		}
		for (int n = 0; n < 4; n++) {
			switch(n) {
			case 0:
				x = M/2;
				y = 0;
				dx = M;
				dy = N/2;
				break;
			case 1:
				x = M/2;
				y = N/2;
				dx = M;
				dy = N;
				break;
			case 2:
				x = 0;
				y = N/2;
				dx = M/2;
				dy = N;
				break;
			case 3:
				x = 0;
				y = 0;
				dx = M/2;
				dy = N/2;
				break;

			}
			for(int i = y; i < dy; i++) {
				for(int j = x; j <dx; j++ ) {
					q.add(arr[i][j]);
				}
			}
			for(int i = y; i < dy; i++) {
				for(int j = x; j < dx; j++ ) {
					arr[i][j] = q.poll();
				}
			}
		}
		q.clear();

	}
	public static void arr6() {
		Queue<Integer> q = new LinkedList<>();
		int x =0,y=0,dx=0,dy=0;
		for(int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				q.add(arr[i][j]);
			}
		}
		for (int n = 0; n < 4; n++) {
			switch(n) {
			case 0:
				x = 0;
				y = N/2;
				dx = M/2;
				dy = N;
				break;
			case 1:
				x = M/2;
				y = N/2;
				dx = M;
				dy = N;
				break;
			case 2:
				x = M/2;
				y = 0;
				dx = M;
				dy = N/2;
				break;
			case 3:
				x = 0;
				y = 0;
				dx = M/2;
				dy = N/2;
				break;

			}
			for(int i = y; i < dy; i++) {
				for(int j = x; j <dx; j++ ) {
					q.add(arr[i][j]);
				}
			}
			for(int i = y; i < dy; i++) {
				for(int j = x; j < dx; j++ ) {
					arr[i][j] = q.poll();
				}
			}
		}
		q.clear();
	}
}
