package BOJ11729_하노이탑이동순서;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		N = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, N) - 1).append("\n");
		
		hanoi(N, 1, 2, 3);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	private static void hanoi(int n, int a, int b, int c) {
		
		if(n == 1) {
			sb.append(a+" "+ c +"\n");
			return;
		}
		
		// N-1 개를 A->B
		hanoi(n-1,a,c,b);
		
		// 1개를 A->C
		sb.append(a+" "+c+"\n");
		
		// N-1개를 B->C
		hanoi(n-1,b,a,c);
		
	}

}
