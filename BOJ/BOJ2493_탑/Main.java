package BOJ2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] result, top;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;

		Stack<Integer > stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		top = new int[N]; // 탑 높이 배열
		result = new int[N]; // 결과 배열

		st = new StringTokenizer(br.readLine()," ");

		for(int i = 0; i < N; i++) { // 배열에 탑 높이 입력
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1; i >=0; i--) {
			if(i == 0) {
				while(!stack.isEmpty() && stack.peek() <= top[i]) {
					stack.pop();
					result[stack.pop()] = i;
				}
				continue;
			}
			
			if(top[i] < top[i-1]) {
				result[i] = i;
					while(!stack.isEmpty() && stack.peek() <= top[i-1]) {						
						stack.pop();
						result[stack.pop()] = i;
					}
				}
			else {
				stack.push(i);
				stack.push(top[i]);
			}
		}

		for(int i = 0; i < result.length; i++) bw.write(result[i]+" ");
		bw.flush();
		bw.close();
		
		br.close();

	}

}
