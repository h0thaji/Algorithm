package SWE3499_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<String> fQue = new LinkedList<>();
		Queue<String> sQue = new LinkedList<>();
		
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <=TC; t++) {
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			int size = N/2;
			
			if(size % 2 == 1) size++;
			
			
			
//			int size = Integer.parseInt(br.readLine());
//			st = new StringTokenizer(br.readLine()," ");
//			
//			//System.out.println(st.countTokens());
//			if(size % 2 == 0) {
//
//				for(int i = 0; i< size/2 ; i++) {
//					fQue.add(st.nextToken());
//				}
//				for(int i = 0; i< size/2; i++) {
//					sQue.add(st.nextToken());
//				}
//				zktr
//			}
//			else {
//				for(int i = 0; i< size/2+1 ; i++) {
//					fQue.add(st.nextToken());
//				}
//				for(int i = 0; i< size/2 ; i++) {
//					sQue.add(st.nextToken());
//				}
//			}
//			
//			String result ="";
//			while(!fQue.isEmpty()) {
//				result += fQue.poll()+" ";
//				if(sQue.isEmpty()) continue;
//				result += sQue.poll()+" ";
//			}
//
//			bw.write("#"+t+" "+result+"\n");

		}
		bw.flush();
		bw.close();
		
		br.close();

	}

}
