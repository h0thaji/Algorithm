package BOJ2851_슈퍼마리오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr = new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());
			arr[i] = sum;
		}

		sum = 0;
		
		for (int i = 0; i < 10; i++) {

			if(arr[i] == 100) {
				sum = 100;
				break;
			}
			int tmp = Math.abs(100 - arr[i]);
			int min = Math.abs(100 - sum);

			if(tmp < min) sum = arr[i];
			else if(tmp == min) sum = Math.max(arr[i], sum);
			
		}
		System.out.println(sum);


	}


}
