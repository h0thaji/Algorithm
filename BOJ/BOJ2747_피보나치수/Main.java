package BOJ2747_피보나치수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//public class Main {
//	static int N;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		N = Integer.parseInt(br.readLine());
//		int[] fibo = new int[N+1];
//		
//		fibo[0] = 0;
//		fibo[1] = 1;
//		
//		for(int i = 2; i <= N; i++)
//			fibo[i] = fibo[i-1] + fibo[i-2];
//		
//		bw.write(String.valueOf(fibo[N]));
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(fibo(N)));
		bw.flush();
		bw.close();
		br.close();
	}
	private static int fibo(int n) {
		if(n <= 1) return n;
		return fibo(n-1) + fibo(n-2);
	}
}
