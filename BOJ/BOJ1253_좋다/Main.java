package BOJ1253_좋다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		bw.write(isGood() + "");
		bw.flush();
		bw.close();
		br.close();

	}
	private static int isGood() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int l = 0, r = N-1;
			
			while(true) {
				if(l == i) l++;
				if(r == i) r--;
				if(l >= r) break;
				
				int sum = arr[l] + arr[r];
				if(sum == arr[i]) {
					cnt++;
					break;
				}
				
				else if(sum > arr[i]) r--;
				else l++;
			}
			
			
		}
		return cnt;
	}

}
