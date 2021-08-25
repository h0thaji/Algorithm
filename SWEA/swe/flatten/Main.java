package swe.flatten;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] arr;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in );

		int TC = 10;
		for(int t = 1 ; t <= TC; t++) {
			arr = new int[100];
			int dumpCnt = sc.nextInt();

			for (int j = 0; j < arr.length; j++) arr[j] = sc.nextInt();

			dump(dumpCnt);
			sb.append("#").append(t).append(" ").append(arr[arr.length-1] - arr[0]).append("\n");
		}
		
		System.out.println(sb);		
		sc.close();

	}

	public static void dump(int dumpCnt) {
		Arrays.sort(arr);
		if(arr[arr.length-1] - arr[0] == 1 || dumpCnt == 0) return;

		arr[arr.length-1]--;
		arr[0]++;
		dump(--dumpCnt);				
	}

}
