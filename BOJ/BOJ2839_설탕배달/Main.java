package BOJ2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int F = 5;
	static final int T = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		while(true) {
			if(N == 0) break;
			if(N < F && N % T !=0) {
				result = -1;
				break;
			}
			if(N % F == 0 || N % F == 3) {
				result += N / F;
				N = N%F;
				System.out.println(N);
			}
			if(N != 0 && N % T == 0) {
				result += N / T;
				N = N%T;
			}

		}
		 System.out.println(result);

		br.close();
	}

}
