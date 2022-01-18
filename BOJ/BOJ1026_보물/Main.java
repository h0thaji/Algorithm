package BOJ1026_보물;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int[] arr1;
    static Integer[] arr2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        result = 0;

        arr1 = new int[N];
        arr2 = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
               arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            result += arr1[i] * arr2[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }
}
