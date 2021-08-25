package SWE6808_규영이와인영이의카드게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int[] in, gyu, selected;
	static boolean[] v;
	static int win, lose;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st=new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= TC; t++) {
			in = new int[10];
			gyu = new int[10];
			selected = new int[9];
			v = new boolean[19];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				gyu[j] = Integer.parseInt(st.nextToken());

				v[gyu[j]] = true;

			}
			int cnt = 0;
			for (int j = 1; j < 19; j++) {
				if(!v[j]) {
					
					in[cnt++] = j;
				}
			}
			
			win = 0;
			lose = 0;
			card(0,0);
			sb.append(String.format("#%d %d %d\n",t,win, lose ));
		}
		System.out.println(sb);
	}
	public static void card(int cnt, int flag) {
		if(cnt == 9) {
			gyu[9] = 0;
			in[9] = 0;
			for (int i = 0; i < 9; i++) {
				int sum = selected[i] + gyu[i];
				if(gyu[i] > selected[i]) {
					gyu[9] += sum;
				}
				else if(gyu[i] < selected[i]) {

					in[9] += sum;
				}
			}

			if(gyu[9] > in[9]) win++;
			else if(gyu[9] < in[9]) lose++; 
		}
		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;
			selected[cnt] = in[i];
			card(cnt+1,flag | 1<<i);
		}
	}
}
