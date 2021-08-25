package BOJ10816_숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(upperIdx(target, N)-lowerIdx(target, N)).append(" ");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}
	private static int lowerIdx(int target, int len) {
		int start = 0;
		int end = len;
		while(start < end) {
			int mid = (start+end) /2;
			if(arr[mid] >= target) end = mid;
			else start = mid+1;
		}
		return start;
	}
	private static int upperIdx(int target, int len) {
		int start = 0;
		int end = len;
		while(start < end) {
			int mid = (start+end) /2;
			if(arr[mid] > target) end = mid;
			else start = mid+1;
		}
		return start;
	}

}
