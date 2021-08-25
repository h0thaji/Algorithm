package BOJ13335_트럭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,w,L;
	static int[] truck;
	static Queue<Integer> bridge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		truck = new int[n];
		bridge = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < n;) {
			
			if(sum <= L && bridge.size() <= w) {
				bridge.offer(Integer.parseInt(st.nextToken()));
				sum += bridge.peek();
				i++;
			}else {
				
				sum -= bridge.poll();
			}
			
		}
		
		int res = 0;
		int tmp = 0;
		int cnt = 0;
		for (int i = 0; i < n;) {
			tmp += truck[i];
			if(tmp > L) {
				cnt++;
				tmp = 0;
			}else {
				i++;
			}
		}
		
		System.out.println(cnt);
	}


}
