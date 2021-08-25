package BOJ1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// #N1919_트리 순회
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 트리 클래스를 생성
		// 링크드리스트사용하면 좋을듯
		LinkedList<Node> node;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			st = new StringTokenizer(inputStr);
//			node = new Node();
		}		
	}
}

class Node{
	String mid;
	String left;
	String right;
	
	public Node(String mid,String left, String right) {
		this.mid = mid;
		this.left = left;
		this.right = right;
	}
}
