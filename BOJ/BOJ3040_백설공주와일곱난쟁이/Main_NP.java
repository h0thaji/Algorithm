package BOJ3040_백설공주와일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_NP {

	static final int N = 9;
	static final int R = 7;
	static int[] arr, p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		arr = new int[N];
		p = new int[N];
		for (int i = 0; i < N; i++) arr[i]= Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(++cnt <= R) p[N-cnt] = 1; // nan배열에 1만큼
		
		do {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(p[i] == 1) sum+= arr[i];
			}
			if(sum == 100) {
				for (int i = 0; i < N; i++) {
					if(p[i] == 1) System.out.println(arr[i]);;
				}
				break;
			}
		}while(np());
		
		
				
	}
	
	private static boolean np() {
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j] ) --j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i < k) swap(i++,k--);
		
		return true;
		
	}
	
	private static void swap(int i , int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
