package BOJ2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int[] dwarf = new int[9];
	static boolean[] v = new boolean[9];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dwarf);
		whoDwarf(0, 0);

	}
	private static void whoDwarf(int cnt, int sum) throws IOException {
		if(cnt == 7 && sum == 100) {
			for(int i = 0; i < 9; i++) {
				if(v[i]) sb.append(dwarf[i]).append("\n");
			}
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			System.exit(0);
		}
		
		for(int i = cnt; i < 9; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			sum +=dwarf[i];
			whoDwarf(cnt+1,sum);
			sum -=dwarf[i];
			v[i] = false;
		}
		
	}

}
