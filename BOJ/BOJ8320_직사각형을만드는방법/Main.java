package BOJ8320_직사각형을만드는방법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j * i <= N ; j++) res++;
		}
		System.out.println(res);
	}

}
