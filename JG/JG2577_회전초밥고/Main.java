package JG2577_회전초밥고;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,D,K,C;
	static int[] belt,sushi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		belt = new int[N];
		sushi = new int[D+1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		sb.append(search());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static int search() {
		int max = 0, eat = 0;
		for (int i = 0; i < K; i++) {
			if(sushi[belt[i]] == 0) eat++;
			sushi[belt[i]]++;
		}
		
		max = eat;
		
		for (int i = 1; i < N; i++) {
			if(max <= eat) {
				if(sushi[C] == 0) max = eat + 1;
				else max = eat;
			}
			
			if(--sushi[belt[i-1]] == 0) eat--;
			
			if(sushi[belt[(i+K-1)%N]]++ == 0 ) eat++;
			
		}
		
		return max;
	}

}
