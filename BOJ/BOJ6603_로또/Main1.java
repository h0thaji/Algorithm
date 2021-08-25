package BOJ6603_로또;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

    static int N = -1, M;
    static int[] input;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            input = new int[N];
            v = new boolean[N];
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            lotto(0,0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void lotto(int cnt,int start) {
        if(cnt == 6){
            for (int i = 0; i < N; i++) {
                if(v[i]){
                    sb.append(input[i]).append(" ");
                }
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            lotto(cnt+1,i+1);
            v[i] = false;
        }
    }
}
