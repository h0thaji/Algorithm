package BOJ2914_크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int M = str.length();
		int res = 0;
		
		for (int i = 0; i < M; i++) {
			int ni = i + 1;
			
			if(str.charAt(i) == '=' && str.charAt(i) == '-') continue;
			if(ni < M ) {
				switch(str.charAt(i)) {
				case 'c':
					if(str.charAt(ni) == '=' || str.charAt(ni) == '-') i = ni;
					break;
					
				case 'd':
					if(str.charAt(ni) == 'z') {
						if(ni+1 < M && str.charAt(ni+1) == '=') i = ni+1;
					}
					else if(str.charAt(ni) == '-') i = ni;
					break;
					
				case 'l':				
				case 'n':
					if(str.charAt(ni) == 'j') i = ni;
					break;
					
				case 's':
				case 'z':
					if(str.charAt(ni) == '=') i = ni;
					break;
				}
				
			}
			res++;
		}

		System.out.println(res);


	}

}
