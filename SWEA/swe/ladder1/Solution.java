package swe.ladder1;

import java.util.Scanner;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int x =0 ,y =0;
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int tc = sc.nextInt();
			arr = new int[100][100];
			

			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					 if(arr[i][j] == 2) {
							x = j;
							y = i;
						}
				}
				
			}
			for(int i = y; i >= 0; i--) {
				boolean check = false;
				while(x+1 < arr.length && arr[i][x+1] == 1) {
					check = true;
					x++;
				}
				while(x-1 >= 0 && arr[i][x-1] == 1 && check == false) {
					x--;
				}

			}
			
			sb.append("#").append(test_case).append(" ").append(x).append("\n");		
		}
		System.out.println(sb);
	}

}
