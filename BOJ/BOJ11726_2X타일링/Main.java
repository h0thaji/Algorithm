package BOJ11726_2X타일링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static int[] DP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];

        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i <= N; i++) DP[i] = (DP[i-2] + DP[i-1]) % 10007;

        bw.write(String.valueOf(DP[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
