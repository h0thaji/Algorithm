package SWE1225_암호생성기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

				
		
		
		for (int t = 1; t <= 10; t++) {
			int TC = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			Queue<Integer> psw = new LinkedList<Integer>();
			
			
			
			for (int i = 0; i < 8; i++) {
				psw.offer(Integer.parseInt(st.nextToken()));
			}
			int save = 1;
			boolean check = true;
			while(check) {
				for(int i = 1; i <= 5; i++ ) {

					save = psw.poll()-i;
					
					if(save <= 0) {
						save = 0;
						psw.offer(save);
						check = false;
						break;
					}
					else psw.offer(save);
				}
			}
			bw.write("#"+TC+" ");
			for(int i = 0; i < 8; i++) {
				bw.write(psw.poll()+" ");
			}
			bw.write("\n");
			
		}
		br.close();
		
		bw.flush();
		bw.close();
	}


}


