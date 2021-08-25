package BOJ10828_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
				
		Stack<Integer> s = new Stack<>();
		N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			switch(input) {
			case "push":
				s.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				if(s.isEmpty()) sb.append(-1);
				else sb.append(s.pop());
				break;
			case "size":
				sb.append(s.size());
				break;
			case "empty":
				if(s.isEmpty()) sb.append(1);
				else sb.append(0);
				break;
			case "top":
				if(s.isEmpty()) sb.append(-1);
				else sb.append(s.peek());
				break;
			}
			sb.append(input.equals("push")? "" : "\n");
		
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
