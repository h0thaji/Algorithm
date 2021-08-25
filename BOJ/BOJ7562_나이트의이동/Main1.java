package BOJ7562_나이트의이동;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {

    static int T,I;
    static boolean[][] map;
    static Pos END;
    static Queue<Pos> Q;
    static boolean[][] v;

    static class Pos{
        int y,x,w;

        public Pos(int y, int x,int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            I = Integer.parseInt(br.readLine());

            map = new boolean[I][I];
            v = new boolean[I][I];
            Q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Q.add(new Pos(y,x,0));
            map[y][x] = true;

            st = new StringTokenizer(br.readLine());
            END = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);

            sb.append(bfs()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int[][] dir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1},{-1,-2},{1,-2}};
    private static int bfs() {
        while(!Q.isEmpty()){
            Pos p = Q.poll();
            int y = p.y;
            int x = p.x;
            int w = p.w;
            if(END.y == y && END.x == x) return w;

            for (int i = 0; i < 8; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if(check(ny,nx)) continue;
                if(map[ny][nx]) continue;

                Q.add(new Pos(ny,nx,w+1));
                map[ny][nx] = true;
            }
        }
        return -1;
    }

    private static boolean check(int y, int x) {
        return y < 0 || x < 0 || y >= I || x >= I;
    }
}
