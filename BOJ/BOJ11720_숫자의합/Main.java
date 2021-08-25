package BOJ11720_숫자의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N, res = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		for(int i =0; i< N; i++) res += s.charAt(i) - 48;
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

}
