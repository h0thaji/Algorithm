package JG1733_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	 static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    static StringTokenizer tokens;

	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
	 //   input = new BufferedReader(new StringReader(src));

	    // map은 1번부터 시작한다.
	    map = new int[20][20];

	    for (int r = 1; r < map.length; r++) {
	        tokens = new StringTokenizer(input.readLine(), " ");
	        for (int c = 1; c < map[r].length; c++) {
	            map[r][c] = Integer.parseInt(tokens.nextToken());
	        }
	    }
	    // 입력 완료

	    for (int r = 1; r < 20; r++) {
	        for (int c = 1; c < 20; c++) {
	            if (map[r][c] != 0) {
	                // 지점에 대해서 탐색 가능한 방향으로 가보자.
	                for (int d = 0; d < deltas.length; d++) {
	                    // 여기가 출발점이야??? - 방향의 역방향으로 한칸 가보기.. 같은놈이 나오면 안된다.
	                    int nr = r - deltas[d][0];
	                    int nc = c - deltas[d][1];
	                    // 영역안에 있고, 시작점과 같은 값이라면 --> 여기는 출발점이 아냐...
	                    if (isIn(nr, nc) && map[nr][nc] == map[r][c]) {
	                        continue;
	                    }

	                    int result = find(r, c, d);
	                    if (result == 5) {
	                    	//System.out.println(map[r][c] +" "+ map[nr][nc]+" "+d);
	                        System.out.println(map[r][c] + "\n" + r + " " + c);
	                        return;
	                    }
	                }
	            }
	        }
	    }
	    System.out.println(0);
	}

	/**
	 * 
	 * @param r 출발점 r
	 * @param c 출발점 c
	 * @param d 방향
	 * @return
	 */
	private static int find(int r, int c, int d) {
	    for (int cnt = 0;; cnt++) {
	        int nr = r + deltas[d][0] * cnt;
	        int nc = c + deltas[d][1] * cnt;

	        // 이런 탐색을 언제 그만둘까? 범위 안에 없다면 또는 돌의 색이 다르다면...
	        if (!isIn(nr, nc) || map[r][c] != map[nr][nc]) {
	            return cnt;
	        }
	    }
	}

	static boolean isIn(int r, int c) {
	    return 1 <= r && r < 20 && 1 <= c && c < 20;
	}

//	static String src = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" +
//	        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";

}
