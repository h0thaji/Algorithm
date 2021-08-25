package BOJ2470_두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int res1 = 0, res2 =0;
		
		//boolean checkNeg = false, checkPos = false;
		int min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			
//			if(checkPos && checkNeg)  continue;
//			if(arr[i] < 1)  checkNeg = true;
//			else checkPos = true;
		}
		
		Arrays.sort(arr);
		
//		if(!(checkPos && checkNeg)) {
//			if(checkPos) System.out.printf("%d %d", arr[0], arr[1]);
//				
//			else System.out.printf("%d %d", arr[N-2], arr[N-1]);
//			return;			
//		}
//		
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			int abs = Math.abs(sum);
			
			if(abs < min) {
				res1 = arr[left];
				res2 = arr[right];
				min = abs;
			}
			
			if(sum < 0) left++;
			else right--;
		}
		
		System.out.printf("%d %d",res1,res2);
		
	}

}
