package BOJ3040_백설공주와일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int N = 9;
	static final int R = 7;
	static int[] arr, nan;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		arr = new int[N];
		nan = new int[R];
		for (int i = 0; i < N; i++) arr[i]= Integer.parseInt(br.readLine());
		
		com(0,0);
				
	}
	
	private static void com(int cnt,int s) {
		if(cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) sum+= nan[i];
			
			if(sum == 100) {
				for(int a : nan) System.out.println(a);
			}
			return;
		}
		for(int i = s; i < N; i++) {
			nan[cnt] = arr[i];
			com(cnt+1,i+1);
		}
	}
}
