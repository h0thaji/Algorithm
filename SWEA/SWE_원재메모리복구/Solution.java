package SWE_원재메모리복구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Solution {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder("");
//		//Scanner sc = new Scanner(System.in);
//		
//		int TC = Integer.parseInt(bf.readLine());
//		
//		for (int t = 1; t <= TC; t++) {
//			
//			String str = bf.readLine();
//			char[] bit = new char[str.length()];
//			for(int i = 0 ; i < bit.length; i++) {
//				bit[i] = str.charAt(i);
//			}
//			
//			int result = 0;
//			for(int i = bit.length-1; i >= 0; i--) {
//				if(i == 0 ) {
//					int temp = i;
//					if(bit[i] != '0') result++;
//							
//					while(temp <= bit.length-1) {
//						bit[temp++] = '0';
//					}
//					//result++;
//					//for(char c: bit) System.out.print(c);
//				}
//				else if(bit[i] != bit[i-1]) {
//					int temp = i;
//					while(temp <= bit.length-1) {
//						bit[temp++] = bit[i-1];
//					}
//					result++;
//					//for(char c: bit) System.out.print(c);
//				}
////				System.out.println();
////				System.out.println(result);
//			}
//			sb.append("#"+t+" ").append(result).append("\n");
////			st = new StringTokenizer(bf.readLine());
////			System.out.println(st.countTokens());
//			
//			//System.out.println(st.countTokens());
////			for(int i = st.countTokens(); i >)
//			
//		}
//		System.out.println(sb);
//	}
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for (int i = 0; i < t; i++) {

         int cnt = 0; // 0과 1을 분별하는 카운트
         int rcnt = 0; // 바꿔야하는 총 횟수

         String str = br.readLine();
         char[] crr = new char[str.length()];
         crr = str.toCharArray(); // 횟수만 출력하면 된다.

         for (int j = 0; j < crr.length; j++) {
            if (crr[j] == '1' && cnt == 0) {
               cnt++;
               rcnt++;
            } else if (crr[j] == '0' && cnt == 1) {
               cnt--;
               rcnt++;
            }
         }

         System.out.println("#" + (i + 1) + " " + rcnt);
      }
   }

}
