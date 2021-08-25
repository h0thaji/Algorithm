package BOJ14696_딱지놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A,B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			
			A = new int [5];
			B = new int [5];
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < M; j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			for (int j = 4; j >= 1; j--) {
				if(A[j] == B[j]) {
					if(j==1) sb.append("D\n");
					continue;
				}		
				if(A[j] > B[j]) {
					sb.append("A\n");
				} else sb.append("B\n");
				
				break;
			}
			
		}
		System.out.println(sb);
	}

}
