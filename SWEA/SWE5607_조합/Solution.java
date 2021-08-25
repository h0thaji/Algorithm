package SWE5607_조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static final int P = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			sb.append(nCr(N,R)).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
	}
	private static long nCr(int n, int r) {
		if(r==0) return 1;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1] * i % P;
		}
		return (fac[n] * 
				power(fac[r]) % P * 
				power(fac[n-r]) % P) 
				% P;
	}
	private static long power(long x) {
		long res = 1;
		long y = P-2;
		x = x % P;
		
		while(y>0) {
			
			if(y%2==1) res = (res * x) % P;
			
			y = y >> 1;
			x = (x*x) % P;
		}
		return res;
	}

}
