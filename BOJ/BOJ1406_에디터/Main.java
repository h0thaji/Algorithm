package BOJ1406_에디터;

import java.io.*;
import java.util.Stack;


public class Main {

    static Stack<Character> leftS = new Stack<>();
    static Stack<Character> rightS = new Stack<>();

    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++){
            leftS.push(input.charAt(i));
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String command = br.readLine();

            switch (command.charAt(0)){
                case 'L':
                    if(!leftS.isEmpty()) rightS.push(leftS.pop());
                    break;
                case 'D':
                    if(!rightS.isEmpty()) leftS.push(rightS.pop());
                    break;
                case 'B':
                    if(!leftS.isEmpty()) leftS.pop();
                    break;
                case 'P':
                    leftS.push(command.charAt(2));
                    break;
            }

        }

        while(!leftS.isEmpty()) rightS.push(leftS.pop());
        while(!rightS.isEmpty()) sb.append(rightS.pop());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
