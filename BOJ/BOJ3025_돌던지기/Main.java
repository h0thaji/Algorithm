package BOJ3025_돌던지기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char[][] map;
    static int[] stones;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        stones = new int[C];
        Arrays.fill(stones, -1);

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine()) - 1;
            int y = stones[x] == -1 ? 0 : stones[x];

            if (y == 0)//해당 위치에 돌이 없다면
                down(y, x);
            else{ //해당 위치에 돌이 있다면

//               왼쪽
                int ny = y + 1;
                int nx = x - 1;

                if(ny < R && nx >= 0 && map[ny][nx] == '.') {
                    down(ny,nx);
                    continue;
                }

                // 오른쪽
               // nx = x + 1;

                if(ny < R && nx < C && map[ny][nx] == '.') {
                    down(ny,nx);
                    continue;
                }

                //둘다 해당없음

                stones[x] = y;
                map[y][x] = 'O';
            }

        }

        for(char[] c : map){
            for(char c2 : c){
                sb.append(c2);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void down(int y, int x) {

        while (y < R) {
            int ny = y + 1;

            if (y + 1 == R || map[y + 1][x] != '.') { // 맨 아래쪽이라면
                map[y][x] = 'O';
                stones[x] = y;
                break;
            }
            y++;

        }
    }
}
