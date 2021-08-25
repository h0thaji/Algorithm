package BOJ10974_모든순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
	
		for (int i = 0, j = 1; i < N; i++,j++) arr[i] = j;
				
		do {
			for(int a : arr) sb.append(String.format("%d ", a));
			sb.append("\n");
		}while(np());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static boolean np() {
		
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i < k) swap(i++,k--);
		return true;
	}
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}


}
