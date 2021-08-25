package BOJ1012_유기농배추;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T,N,M,K;
    static int[][] map;
    static boolean[][] v;
    static Queue<Pos> Q;
    static class Pos{
        int y,x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());


        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];
            Q = new LinkedList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !v[i][j]){
                        Q.add(new Pos(i,j));
                        v[i][j] = true;
                        bfs();
                       cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static void bfs() {
        while(!Q.isEmpty()){
            Pos p = Q.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if(check(ny,nx)) continue;
                if(v[ny][nx]) continue;
                if(map[ny][nx] == 1){
                    Q.add(new Pos(ny,nx));
                    v[ny][nx] = true;
                }

            }

        }
    }

    private static boolean check(int y, int x) {
        return x < 0 || y < 0 || y >= N || x >= M;
    }
}
