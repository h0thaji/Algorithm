package BOJ10989_수정렬하기3;

import java.io.*;

public class Main {
    static int N;
    static int[] arr,counting,result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        counting = new int[10001];
        result = new int[N];

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            counting[input]++;

        }

        for(int i = 1; i < 10001; i++){
            counting[i]+=counting[i-1];
        }

        for(int i = N-1; i >= 0; i--){
            int idx = arr[i];
            result[--counting[idx]] = idx;
        }

        for(int a : result) sb.append(a).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
