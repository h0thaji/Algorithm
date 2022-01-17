package BOJ1920_수찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int m) {
        int start = 0;
        int end = N-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(m < arr[mid]){
                end = mid-1;
            }else if(m > arr[mid]) start = mid+1;
            else return 1;
        }

        return 0;
    }
}
