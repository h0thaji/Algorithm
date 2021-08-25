package BOJ2564_경비원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,res = 0;
	static int dir, k;
	static int[] point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());
		point = new int[N+1];
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			switch(dir) {
			case 1:
				point[i] = k;
				break;
			case 2:
				point[i] = x+y+(x-k);
				break;
			case 3:
				point[i] = 2*x+y+(y-k);
				break;
			case 4:
				point[i] = x+k;
				break;
			}
			
		}
		
		
		for (int i = 0; i < N; i++) {
			int tmp = Math.abs(point[N] - point[i]);
			int r = x + y;
			res += tmp > r ? r*2 - tmp : tmp; 
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
		
	}
	

}
