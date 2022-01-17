package BOJ2751_수정렬하기2;

import java.io.*;

/*
계수정렬
시간복잡도 n
퀵, 힙, 합병 보다 빠름 (nlog n)

1. 입력 값을 담은 배열(arr) 와 입력 값이 index가 되는 배열(counting) 생성
2. 입력 값을 counting 시켜줌
3. counting 배열을 누적합으로 바꿔준다.
4. result 배열에 counting 배열의 index값이 나올때마다 하나씩 차감시켜주며 넣어준다.
 */
public class Counting_Sort {

    static int N;
    static int[] arr,counting,result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        counting = new int[2000001];
        result = new int[N];

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine()) + 1000000;
            arr[i] = input;
            counting[input]++;
        }

        prefixSum();
        sort();

        for(int a : result) sb.append(a - 1000000).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void prefixSum(){
        for(int i = 1; i < 2000001; i++){
            counting[i] = counting[i-1] + counting[i];
        }
    }

    public static void sort(){
        for(int i = 0; i < N; i++){
            int index = arr[i];
            counting[index]--;
            result[counting[index]] = index;
        }
    }
}
