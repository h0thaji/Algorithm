package BOJ1592_영식이와친구들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 시계방향으로 1부터 N까지 자리 앉는다
	 * 영식이와 친구들은 공 던지기 게임
	 * 1번자리 시작 -> 공을 던지고 받고 받은 사람 다시 던지고 반복
	 * 한 사람이 공 을 M번 받으면 끝
	 * 공을 M번 보다 적게 받은 사람이 공을 던질 때 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게
	 * 짝수이면 반시계방향으로 L번째 있는사람에게 공 던짐
	 * @param args
	 */
	static int N, M, L, res;
	static int[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		isSelected = new int[N+1]; // 공을 몇 번 받았는지 체크 , 1 시작 배열
		//		홀수면 시계방향 L
		//		짝수면 반시계방향 L

		int i = 1;
		while(true) {
			isSelected[i]++;
			
			if(isSelected[i] == M) break;
			res++;
			//System.out.println( i +" " + res );
			//System.out.println(res);
			if(isSelected[i] % 2 != 0) i = (i+L)%N;
			else i -= L;

			if( i <= 0) i += N;
			
			
		}
		System.out.println(res);
	}
}
