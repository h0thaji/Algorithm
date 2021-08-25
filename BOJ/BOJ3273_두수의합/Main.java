package BOJ3273_두수의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,X;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N =  Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		X = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(search()));
		bw.flush();
		bw.close();
		br.close();

	}
	private static int search() {
		int start = 0;
		int end = N-1;
		int res = 0;
		
		while(start<=end) {
			int sum = arr[start] + arr[end];
			
			if( sum == X) {
				start++;
				end--;
				res++;
			}
			else if(sum > X) end--;
			else start++;
		}
		return res;
	}

}
