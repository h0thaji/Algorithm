package BOJ15552_빠른AB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str;
		
		int tc = Integer.parseInt(bf.readLine());
		while(tc <= 1000000 && tc-- > 0) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
	
		}
		bf.close();
		bw.flush();
		bw.close();
	}
}
