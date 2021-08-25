package SWE1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static String[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			tree = new String[N+1];
			Queue<Integer> q = new LinkedList<>();
			sb.append(String.format("#%d ", t));

			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();				
			}

			int h =(int) baseLog((double)(N+1),(double)2); // 높이 계산
			int L = (int)Math.pow(2, h); // 마지막 높이 시작 숫자

			//마지막 레벨 계산해서 피연사인지 확인
			boolean c = false;
			for (int i = L; i < tree.length; i++) {
				
				if(tree[i].equals("*") || tree[i].equals("/") || tree[i].equals("+") || tree[i].equals("-")) {
					c = true;
					break;
				}
			}
			if(c) {
				sb.append(0+"\n");
				continue;
			}
			
			q.offer(1);
			int cur;
			L = (int)Math.pow(2, h-1); // 마지막 높이는 빼고 확인, h-1 시작 숫자
			while(!q.isEmpty()) {
				cur = q.poll();
				// 해당 노드가 연산자인지 확인				
				if(!(tree[cur].equals("*")|| tree[cur].equals("/")|| tree[cur].equals("+")|| tree[cur].equals("-"))) {
					c = true;
					break;
				}
				
				if(cur*2 < L) q.offer(cur*2);
				if(cur*2 +1< L) q.offer(cur*2+1);
			}
			if(c) {
				sb.append(0+"\n");
				continue;
			}
			sb.append(1+"\n");
		}
		System.out.println(sb);

	}
	static double baseLog(double x, double base) {
		return Math.log(x) / Math.log(base);
	}

}
