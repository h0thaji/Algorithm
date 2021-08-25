package BOJ1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, res = Integer.MIN_VALUE, R;
	static String[] str;
	static List<Character> alpabet = new ArrayList();
	static int[] val;
	static boolean[] v = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			for (int j = 0; j < str[i].length(); j++) {
				if(!alpabet.contains(str[i].charAt(j))) alpabet.add(str[i].charAt(j));
			}
		}
		
		R = alpabet.size();
		val = new int[R];
		
		dfs(0);
		System.out.println(res);
		br.close();
		
		

	}

	private static void dfs(int cnt) {
		
		if(cnt == R) {
			int sum = 0;
//			for (int a : val) {
//				System.out.print(a +" ");
//			}
//			System.out.println();
			for (int i = 0; i < N; i++) {
				int num = 0;
				
				for (int j = 0; j < str[i].length(); j++) {
					num *= 10;
					num += val[alpabet.indexOf(str[i].charAt(j))];
				}
				sum += num;
			}
			res = Math.max(res, sum	);
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if(v[i]) continue;
			v[i] = true;
			val[cnt] = i;
			dfs(cnt+1);
			//val[cnt] = 0;
			v[i] = false;
		}
		
	}

}
