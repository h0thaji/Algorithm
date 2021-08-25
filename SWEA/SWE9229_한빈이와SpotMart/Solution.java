package SWE9229_한빈이와SpotMart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N,M;
	static int[] W, sum;
	static int  max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자봉지 수
			M = Integer.parseInt(st.nextToken()); // 과자 최대 무게
			
			W = new int[N]; // 과자 무게 담을 배열
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken()); // 과자 무게 입력
			}
			
			sum = new int[2]; // sum 배열 생성
			max = 0; //max 초기화

			snack(0,0);
			max = max ==0? -1: max; // max 값이 0이면 두 과자를 들고 갈 방법이 없음
			bw.append("#"+t+" "+max+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void snack(int cnt, int s) {
		if(cnt == 2) {
			int G = sum[0]+sum[1];
			if(G <= M && max < G){
				max = G;
				return;
			}
			return;
		}
		
		for(int i = s; i < N; i++) {
			sum[cnt] = W[i];
			snack(cnt+1,i+1);
		}
	}

}
