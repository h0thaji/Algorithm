package SWE1228_암호문1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		
		for (int t = 1; t <= 10; t++) {
			LinkedList<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				//int s = Integer.parseInt(st.nextToken());
				for (int j = x; j < x+y ; j++) {
					list.add(j, st.nextToken());
				}
			}
			
			
			bw.append("#"+t+" ");
			int cnt = 0;
			while(cnt < 10) {
				bw.append(list.get(cnt++)+" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
