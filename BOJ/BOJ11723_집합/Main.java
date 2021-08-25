package BOJ11723_집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int num = 0;
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int x;
			
			switch(str) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				num =num | 1 << x-1;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				if((num & 1<<x-1) != 0) num = num ^ 1<< x-1;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if((num & 1<<x-1) != 0) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if((num & 1<<x-1) != 0) num = num ^ 1<< x-1;
				else num =num | 1 << x-1;
				break;
			case "all":
				for (int i = 0; i < 20; i++) {
					num =num | 1 << i;
				}
				break;
			case "empty":
				num = 0;
				break;
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();

	}

}
