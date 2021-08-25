package BOJ2661_좋은수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N,m;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		back("");
	}
	
	private static void back(String sequence) throws IOException {
		
		if(sequence.length() == N) {
			bw.write(sequence);
			bw.flush();
			bw.close();
			br.close();
			
			System.exit(0);
		}else{
			for (int i = 1; i < 4; i++) {
				if(isSequnce(sequence+i)) back(sequence+i);
			}
		}
	}
	
	private static boolean isSequnce(String sequence) {
		
		int last = sequence.length();
		int l = last / 2 + 1;
		
		for (int i = 1; i < l; i++) {
			
			int pre = last - i;
			
			if(sequence.substring(pre, last).equals(sequence.substring(pre - i, pre)))
				return false;
		}
		return true;
	}

}
