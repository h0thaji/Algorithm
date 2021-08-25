package BOJ3079_입국심사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		T = new int[N];
		int min = 1000000001;
		for(int i = 0; i < N; i++) {
			int sec = Integer.parseInt(br.readLine());
			//min = Math.min(sec, min);
			T[i] = sec;
		}
		Arrays.sort(T);
		bw.write(String.valueOf(binarySearch()));
		bw.flush();
		bw.close();
		br.close();
	}
	private static long binarySearch() {
		
		long start = 1;
		long end = (long) T[N-1] * M;
		//System.out.println(end);
		long mid = (end + start) / 2;
		//System.out.println(mid);
		long res = 0;
		while(start <= end) {
			long cnt = 0;
			for(int i = 0; i < N; i++) {
				if(cnt >= M) {
					break;
				}
				cnt += mid / T[i];
			}
			//System.out.println("start : "+start+" /end : "+end+" /mid : "+mid+" /cnt : "+ cnt);
			if(cnt >= M) {
				end = mid - 1;
				res = mid;
			}
			else if(cnt < M) start = mid + 1;
			
			mid = (end + start) / 2; 
		}
		return res;
		
	}

}
