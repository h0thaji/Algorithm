package BOJ10845_큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static class MyQ{
		ArrayList<Integer> q;
		
		public MyQ() {
			this.q = new ArrayList<>();
		}
		
		void push(int a) {
			q.add(a);
		}
		
		int pop() {
			if(q.size() != 0) {
				int front = q.get(0);
				q.remove(0);
				return front;
			}
			else return -1;
		}
		
		int size() {
			return q.size();
		}
		
		int front() {
			if(q.size() != 0 ) return q.get(0);
			else return -1;
		}
		
		int back() {
			if(q.size() != 0 ) return q.get(q.size() -1);
			return -1;
		}
		
		int empty() {
			if(q.size() == 0) return 1;
			else return 0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		MyQ myQ = new MyQ();
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push" :
				myQ.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				sb.append(myQ.pop());
				sb.append("\n");
				break;
			case "front" :
				sb.append(myQ.front());
				sb.append("\n");
				break;
			case "back" :
				sb.append(myQ.back());
				sb.append("\n");
				break;
			case "size" :
				sb.append(myQ.size());
				sb.append("\n");
				break;
			case "empty" :
				sb.append(myQ.empty());
				sb.append("\n");
				break;
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
