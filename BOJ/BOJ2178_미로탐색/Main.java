package BOJ2178_미로탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static Queue<Pos> Q;

    static class Pos{
        int y,x,w;
        public Pos(int y, int x, int w){
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken())+1;
        map = new int[N][M];
        Q = new LinkedList<>();

        for (int i = 1; i < N; i++) {
            String input = br.readLine();
            for (int j = 1; j < M; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        Q.add(new Pos(1,1,0));
        map[1][1] = 0;
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();


    }

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static int bfs(){
        while(!Q.isEmpty()){
            Pos p = Q.poll();
            int y = p.y;
            int x = p.x;
            int w = p.w;

            if(y == N-1 && x == M-1){
                return w+1;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if(check(ny, nx)) continue;
                if(map[ny][nx] == 1) {
                    Q.add(new Pos(ny,nx,w+1));
                    map[ny][nx] = 0;
                }
            }
        }
        return 0;
    }

    private static boolean check(int y, int x) {
        return y < 1 || x < 1 || y >= N || x >= M;
    }
}
