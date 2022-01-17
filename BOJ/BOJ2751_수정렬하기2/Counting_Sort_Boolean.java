package BOJ2751_수정렬하기2;

import java.io.*;

public class Counting_Sort_Boolean {

    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new boolean[2000001];

        for(int i = 0; i < N; i++){
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for(int i = 0; i < 2000001; i++){
            if(arr[i]) sb.append(i - 1000000).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
