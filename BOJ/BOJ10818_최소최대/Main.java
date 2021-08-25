package BOJ10818_최소최대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// #10818_최소, 최대
// 오래걸리니 수정.
//
//
//
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		System.out.println(num);
//		num = Integer.parseInt(st.nextToken());
//		System.out.println(num);
		int max = num;
		int min = num;
				
		if(n >=1 && n <= 1000000) {
			for (int i = 1; i <n; i++) {
				num = Integer.parseInt(st.nextToken());
				if(max < num) max = num;
				if(min > num) min = num;
			}
			System.out.printf("%d %d",min,max);
			
		}		
		
	}

}
