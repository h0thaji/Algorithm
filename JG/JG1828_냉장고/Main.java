package JG1828_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, res = 1; // 재료의 수, 결과값
	static int[][] arr; // 재료넣을 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// 재료 배열에 재료 최저, 최고 온도 삽입
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 재료 최저온도순으로 정렬
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0] , o2[0]));
		
		

		int y = arr[0][1]; // 현재 냉장고의 최고온도
		// 최저온도순으로 정렬했기때문에 최저온도는 다음인덱스로 넘어갈때마다 새로운 냉장고를 안찾아봐도 되기에 비교 X
		for (int i = 1; i < N; i++) {
			
			if(y >= arr[i][0]) { // 현재 냉장고의 최고온도가 해당 재료 최저온도보다 크거나 같으면 해당 냉장고에 포함
				y = Math.min(y, arr[i][1]); // 최고온도의 최저값이 냉장고의 새 최저 온도가 됨으로 비교
			}
			else { // 냉장고에 포함 X
				res++; // 냉장고 하나 더 추가
				y = arr[i][1]; // 새 냉장고의 재료 최고온도
			}
		}
		
		System.out.println(res);
	}

}
