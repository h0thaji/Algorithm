package BOJ2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
Arrays.sort() 사용하면 시간초과
=> 해당 sort 함수는 dual pivot quick sort 사용 , 최악의 시간복잡도경우 n^2이기 때문에 시간초과가 난다.

Collectios.sort() 사용
=>Tim Sort Algorithm

System.out.print 를 사용하면 시간초과
StringBuilder 나 BufferedWriter 사용해야함
 */
public class Collections_Sort {
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int m = Integer.parseInt(br.readLine());
            arr.add(m);
        }

        Collections.sort(arr);

        for (int a: arr) {
            sb.append(a).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
