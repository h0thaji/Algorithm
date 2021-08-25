package BOJ2916_도영이가만든맛있는음식;

import java.util.Scanner;

public class shortVer {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[][] arr=new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		int result=Integer.MAX_VALUE;
		for(int i=1;i<(1<<N);i++) {
			int t=0,s=1;
			for(int j=0;j<N;j++) {
				if((i&1<<i)>0) {
					s*=arr[j][0];
					t+=arr[j][1];
				}
			}
			result = Math.min(result,Math.abs(s-t));
		}
		System.out.println(result);		
	}
}
