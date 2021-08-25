package SWE5604_구간합;

import java.io.*;
import java.util.*;


public class Solution {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int tc = 1; tc <= T; tc++) {
//			long A = sc.nextLong();
//			long B = sc.nextLong();
//			long[] ans = new long[10];
//			long point = 1;
//			while (A <= B) {
//				while (B % 10 != 9 && A <= B) {
//					cal(B, ans, point);
//					B--;
//				}
//
//				if (B < A) {
//					break;
//				}
//				while (A % 10 != 0 && A <= B) {
//					cal(A, ans, point);
//					A++;
//				}
//
//				A /= 10;
//				B /= 10;
//
//				for (int i = 0; i < 10; i++) {
//					ans[i] += (B - A + 1) * point;
//				}
//				point *= 10;
//			}
//			long sum = 0;
//			for (int i = 0; i < 10; i++) {
//				sum += (ans[i] * i);
//			}
//			
//			System.out.println("#"+tc+" "+sum);
//		}
//	}
//
//	public static void cal(long x, long[] ans, long point) {
//		while (x > 0) {
//			String s = String.valueOf(x);
//			int xx = s.charAt(s.length()-1)-'0';
//			ans[xx] += point;
//			x /= 10;
//		}
//	}
	
	static int T;
	static long A, B, S;
	static HashMap<Long, Long> m = new HashMap<Long, Long>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		m.clear();
		for (int i = 1; i < 17; i++) { 
			long v=pow10(0L+i);
			m.put((v-1L), h(v-1L));
		}

		T= Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			A=Long.parseLong(st.nextToken());
			B=Long.parseLong(st.nextToken());
			
			S=cal(B,A);
			
			sb.append("#").append(t).append(" ").append(S).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static long h(long n) {
		long len=len(n)+1L;
		// f(9) 20f(9) 300f(9) 4000f(9)
		return ((45L)*(len)*(1L+n))/(10L);
	}
	public static long cal(long B,long A){
		if(A<=1){
			return f(B);
		}else if(A==B){
			return f(B)-f(A-1);    // 버그 수정
		}else{
			return f(B)-f(A-1);
		}
	}
	public static long g(long n){
		if(n<=9){
			return e(n);
		}else{
			long v=pow10(len(n));
			return (n/v)*(n%v+1L)+ f(n%v);
		}
	}
	public static long f(long n) {
		if(m.containsKey(n)) {
			return m.get(n);
		}else if(n<=9){
			return e(n);
		}else{
			long v=pow10(len(n));
			m.put(n, f(n-1L-n%v)+g(n));
			return m.get(n);
		}
	}
	public static long e(long n){
		return n*(n+1L)/2L;
	}
	public static long len(long n){
		return 0L+(n+"").length()-1;
	}
	public static long pow10(long n){
		return (long)Math.pow(10, n);
	}

}
