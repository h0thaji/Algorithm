package BOJ10815_숫자카드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
   // static boolean[] counting = new boolean[20000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
           // counting[input + 10000000] = true;

        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int input = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(input)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        //sort();

    }

    private static int binarySearch(int value) {
        int start = 0;
        int end = N - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] < value){
                start = mid + 1;
            }else if(arr[mid] > value){
                end = mid - 1;
            }else return 1;
        }

        return 0;
    }


}
