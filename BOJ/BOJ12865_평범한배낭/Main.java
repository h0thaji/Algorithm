package BOJ12865_평범한배낭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int[][] bag;
	static Item[] item;
	static class Item{
		int w,v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())+1;
		K = Integer.parseInt(st.nextToken())+1;
		
		item = new Item[N];
		bag = new int[N][K];
		
		for (int i = 1; i < N; i++) {
			st =  new StringTokenizer(br.readLine());
			item[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt( st.nextToken()));

		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < K; j++) {
				if(item[i].w <= j) {
					bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-item[i].w]+item[i].v);
				}else bag[i][j] = bag[i-1][j];
			}
		}
		
		sb.append(bag[N-1][K-1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
