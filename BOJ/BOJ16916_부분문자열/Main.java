package BOJ16916_부분문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static String S, P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = br.readLine();
		P = br.readLine();
		
		bw.write(String.valueOf(kmp()));
		bw.flush();
		bw.close();
		br.close();
	}
	private static int kmp() {
		int[] pi = getPi();
		
		int n = S.length(), m = P.length(), j = 0;
		char[] s = S.toCharArray();
		char[] p = P.toCharArray();
		
		for(int i = 0; i < n; i++) {
			while(j > 0 && s[i] != p[j]) j = pi[j-1];
			if(s[i] == p[j]) {
				if( j == m-1) return 1;
				else j++;
			}
		}
		return 0;
	}
	private static int[] getPi() {
		int m = P.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];
		
		p = P.toCharArray();
		for(int i = 1; i < m; i++) {
			while(j > 0 && p[i] != p[j]) j = pi[j - 1];
			if(p[i] == p[j]) pi[i] = ++j;
		}
		return pi;
	}

}
