package BOJ2443_별찍기6;

import java.util.Scanner;

public class Main {

	static String[][] str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		int N = sc.nextInt();
		str = new String[N][2*N];

		for (int i = N; i > 0; i--) {

			for (int j2 = 0; j2 < N-i; j2++) {
				sb.append(" ");
			}
			for (int j = 0; j < (2*i)-1; j++) {
				sb.append("*");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
