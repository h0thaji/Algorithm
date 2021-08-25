package BOJ10972_다음순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr, input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		if(np()) for (int a  : arr) sb.append(String.format("%d ", a));
		else sb.append("-1");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	private static boolean np() {

		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) --i;

		if(i==0) return false;

		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;

		swap(i-1, j);

		int k = N-1;
		while(i < k) swap(i++,k--);

		return true;
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
