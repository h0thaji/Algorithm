package BOJ1182_부분수열의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N, S, res;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int cnt, int sum, int start) {
        if (cnt > 0 && cnt <= N) {
            if (sum == S) res++;
            if (cnt == N) return;
        }
        for (int i = start; i < N; i++) dfs(cnt + 1, sum + arr[i], i + 1);
    }
}
