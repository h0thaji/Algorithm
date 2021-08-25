package BOJ17478_재귀함수가뭔가요;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static String Q = "\"재귀함수가 뭔가요?\"\n";
	static String A = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
			+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
			+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String R = "라고 답변하였지.\n";
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		dfs("",0);
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
			
	}
	private static void dfs(String u, int cnt) {
		sb.append(u).append(Q); // "재귀함수가 뭔가요?"
		
		if(cnt == N) {
			sb.append(u).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(u).append(R); // "라고 답변하였지."
			return ;
		}
		
		StringTokenizer st = new StringTokenizer(A,"\n");
		// "잘 들어보게~"
		while(st.countTokens() != 0) sb.append(u).append(st.nextToken()).append("\n");
		
		dfs(u+"____",cnt+1);
		
		sb.append(u).append(R); // "라고 답변하였지."
		
	}

}
