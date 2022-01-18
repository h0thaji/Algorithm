package BOJ1966_프린터큐;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N, M, temp;
    static LinkedList<Print> q;

    static class Print{
        int idx;
        int priority;

        public Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                q.add(new Print(j,Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;

            while(!q.isEmpty()){
                Print p = q.poll();
                boolean isMax = true;

                for(int j = 0; j < q.size(); j++){
                    if(p.priority < q.get(j).priority){

                        q.add(p);
                        for(int k = 0; k < j; k++) q.add(q.poll());

                        isMax = false;
                        break;

                    }
                }

                if(isMax ){
                    cnt++;
                    if(p.idx == temp) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }

            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
