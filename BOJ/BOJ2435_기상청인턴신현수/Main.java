package BOJ2435_기상청인턴신현수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0, j = 0; i < N; i++){
            temp[i] = Integer.parseInt(st.nextToken());
            if(j < K) sum += temp[j++];
        }

        int max = sum;

        for(int i = K; i < N; i++){
            sum = sum - temp[i-K] + temp[i];
            max = Integer.max(max, sum);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
