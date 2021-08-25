package BOJ17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int Y, X, T, dust;
	static int[][] arr, cleaner = new int[2][2];
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[Y][X];
		for (int i = 0, k = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <X; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					cleaner[k][0] = i;
					cleaner[k++][1] = j;
				}else dust += arr[i][j];
			}
		}
		
		for (int tc = 0; tc < T; tc++) {

			diff(new int[Y][X]);
			airClean(new int[Y][X]);
		}
		
		System.out.println(dust);
		
	}
	
	private static void airClean(int[][] narr) {
		for (int idx = 0; idx < 2; idx++) {
			int ny = cleaner[idx][0];
			int nx = cleaner[idx][1]+1;
			while(nx < X-1) narr[ny][nx+1] = arr[ny][nx++];
			
			if(idx==0) while(ny > 0) narr[ny-1][nx] = arr[ny--][nx];
			else while(ny < Y-1) narr[ny+1][nx] = arr[ny++][nx];
			
			while(nx > 0) narr[ny][nx-1] = arr[ny][nx--];
			
			if(idx==0) while(ny < cleaner[idx][0]-1) narr[ny+1][nx] = arr[ny++][nx];
			else while(ny > cleaner[idx][0]+1) narr[ny-1][nx] = arr[ny--][nx];
			
		}
		dust -= arr[cleaner[0][0]-1][cleaner[0][1]] + arr[cleaner[1][0]+1][cleaner[1][1]];
		
		for (int i = 0; i <Y; i++) {
			for (int j = 0; j < X; j++) {
				if (i == 0 || i == Y - 1 || j == 0 || j == X - 1 || i == cleaner[0][0] || i == cleaner[1][0]) {
					arr[i][j] = narr[i][j];
                }
				
			}
			
			arr[cleaner[0][0]][cleaner[0][1]] = -1;
			arr[cleaner[1][0]][cleaner[1][1]] = -1;
		}
	}

	private static void diff(int[][] narr) {
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(arr[i][j] <5)continue;
				int A = arr[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int ny = i+dir[k][0];
					int nx = j+dir[k][1];
					
					if(search(ny,nx)) continue;
					narr[ny][nx] += A;
					narr[i][j] -= A;
				}
			}
		}
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				arr[i][j]+=narr[i][j];
			}
		}
		
		
	}
	
	private static boolean search(int y, int x) {
		return (y < 0 || y >= Y || x < 0 || x >= X) || arr[y][x]==-1;
	}

}
