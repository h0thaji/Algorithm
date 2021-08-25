package BOJ2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K, tmp = 1;
	static int[][] arr = new int[6][2];
	//static boolean[] check = new boolean[5];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		int[] w = new int[2]; // 가로 / 0: 최대값 , 1: 인덱스
		int[] h = new int[2]; // 세로

		w[0] = 0;
		h[0] = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken()); // 방향
			arr[i][1] = Integer.parseInt(st.nextToken()); // 길이

		}
		
		for (int i = 0; i < 6; i++) {
			
			if(arr[i][0] <= 2) {
				if(w[0] < arr[i][1]) {
					w[0] = arr[i][1];
					w[1] = i;
				}
				
			}
			else {
				if(h[0] < arr[i][1]) {
					h[0] = arr[i][1];
					h[1] = i;
				}
			}	
		}
		
		int x = 0;
		int y = 0;
		
		x = Math.abs(arr[(w[1]+ 5)%6][1] - arr[(w[1]+ 1)%6][1]); 
		
		y = Math.abs(arr[(h[1] + 5) %6][1] - arr[(h[1] + 1) %6][1]); 
		
		System.out.println(((w[0] * h[0]) - (x *y)) * K);
		
		
	}
}

