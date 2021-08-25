package BOJ7568_덩치;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<phsycal> p = new ArrayList<>();
	static class phsycal{
		public int w, h;

		public phsycal(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p.add(new phsycal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < N; i++) {
			int r = 1;
			
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				phsycal p1 = p.get(i);
				phsycal p2 = p.get(j);
				
				if(p1.w < p2.w && p1.h < p2.h) r++;
			}
			
			sb.append(r).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
