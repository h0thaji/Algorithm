package BOJ1157_단어공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String str = br.readLine();
//		int size = str.length();
//		int[] arr = new int[100];
//		int idx = 0,res = 0, max = 0 ;
//		for (int i = 0; i < size; i++) {
//			
//			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
//				idx = str.charAt(i) - 32;
//			}else idx = str.charAt(i);
//			
//			arr[idx]++;
//			
//			if(max < arr[idx]) {
//				res = idx;
//				max = arr[idx];
//			}
//		}
//		
//		for (int i = 65; i < 91; i++) {
//			if(res != i && max == arr[i]) {
//				System.out.println("?");
//				return;
//			}
//		}
//		
//		System.out.println((char)res);
		
		int[] arr = new int[26];
		int c = System.in.read();
		
		while(c>64) {
			if(c < 91) arr[c-65]++;
			else arr[c-97]++;
			c = System.in.read();
		}
		
		int max = -1, res = 0;
		for (int i = 0; i < 26; i++) {
			if(max < arr[i]) {
				max = arr[i];
				res = i;
			}else if (max == arr[i]) res = -2;
		}
		
		System.out.println((char)(res+65));
	}

}
