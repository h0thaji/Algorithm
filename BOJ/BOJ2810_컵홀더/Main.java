package BOJ2810_컵홀더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		boolean check = false;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'S') res++;
			else {
				if(!check) check = true;
				else {
					res++;
					check = false;
				}
			}
		}
		res++;
		res = Math.min(N, res);
		System.out.println(res);

	}

}
