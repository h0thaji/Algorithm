package BOJ2263_트리의순회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,cnt = 0;
	static int[] post,in,position;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		N = Integer.parseInt(br.readLine());
		post = new int[N+1];
		in = new int[N+1];
		position = new int[N+1];
		
		for(int t = 0; t < 2; t++) { //in , post 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i<= N; i++) {
				if(t==0) in[i] = Integer.parseInt(st.nextToken());
				else post[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) position[in[i]] = i; // in의 root의 위치값 저장
		
		getPre(1,N,1,N);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void getPre(int inS, int inE, int postS, int postE) {
		//inS = 인오더 시작점 , inE = 인오더 끝점, postS = 포스트오더 시작점, postE = 포스트오더 끝점
		if(inS > inE || postS > postE) return; // 시작점이 끝점보다 크면 안됨.
		
		int root = post[postE]; // 포스트오더의 끝점이 root
		sb.append(root).append(" ");//순서대로 post 끝점이 pre의 순서가 됨
		
		int p = position[root]; 
		getPre(inS,p-1,postS,postS+(p-inS)-1); // 왼쪽탐색
		getPre(p+1,inE,postS+(p-inS),postE-1); // 오른쪽탐색
		
	}
	

}
