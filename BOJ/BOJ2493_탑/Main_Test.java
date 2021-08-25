package BOJ2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parse(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>(); // height, index

        for (int i = 1;i <= N; i++) {
            int height = parse(st.nextToken());

            // 현재 탑(상대적 위치 왼쪽)과 스택에 있는 탑들(상대적 위치 오른쪽)비교 
            // 현재 탑의 높이보다 기존 탑의 높이가 더 크거나 같으면 레이저가 닿기 때문에
            // 기존 탑의 인덱스를 리턴한다.
            // 반대로 현재 탑의 높이가 기존 탑의 높이보다
            while(!stack.isEmpty()) {
                if(stack.peek()[0] >= height) {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                }
                stack.pop(); // 현재 탑의 높이 > 기존 탑의 높이
            }

            if(stack.isEmpty()) {
                sb.append("0 "); // 현재 탑보다 높은 탑이 없는 경우
            }

            stack.push(new int[] {height, i});
        }

        System.out.println(sb);

    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}