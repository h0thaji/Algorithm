package BOJ5597_과제안내신분;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		
		v = new boolean[31];

		for (int i = 0; i < 28; i++) v[Integer.parseInt(br.readLine())] = true;

		for (int i = 1; i < v.length ; i++) if(!v[i]) sb.append(i+"\n");

		
		System.out.println(sb);
		br.close();

	}

}
