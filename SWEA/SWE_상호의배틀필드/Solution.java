package SWE_상호의배틀필드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int H,W;
	static char[][] map;
	static char[] key;
	static int bx,by;
	static int flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		String str;


		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			//map 입력
			for(int i = 0; i < map.length; i++) {
				str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
						bx = j;
						by = i;
						switch(map[i][j]) {
						case'^':
							flag = 1;
							break;
						case'v':
							flag = 2;
							break;
						case'<':
							flag = 3;
							break;
						case'>':
							flag = 4;
							break;
						}
					}
				}
				//				 탱크 위치 저장				
			}

			//for(char[] c : map) System.out.println(Arrays.toString(c));

			//key 수, key 입력
			int keyCnt = Integer.parseInt(br.readLine());
			key = new char[keyCnt];
			str = br.readLine();
			for (int i = 0; i < keyCnt; i++) {
				key[i] = str.charAt(i);
			}

			for(int i = 0; i < keyCnt; i++) {
				int boomx = 0, boomy = 0;

				switch(key[i]) {
				case 'U':
					if(by-1 >= 0 && map[by-1][bx] == '.') {
						by--;
						map[by+1][bx] = '.';
						map[by][bx] = '^';						
					}
					else map[by][bx] = '^';
					flag = 1;
					break;
				case 'D':
					if(by+1 < H && map[by+1][bx] == '.') {
						by++;
						map[by-1][bx] = '.';
						map[by][bx] = 'v';

					}
					else map[by][bx] = 'v';
					flag = 2;
					
					break;
				case 'L':
					if(bx-1 >= 0 && map[by][bx-1] == '.') {
						bx--;
						map[by][bx+1] = '.';
						map[by][bx] = '<';

					}
					else map[by][bx] = '<';
					flag = 3;
					break;
				case 'R':
					if(bx+1 < W && map[by][bx+1] == '.') {
						bx++;
						map[by][bx-1] = '.';
						map[by][bx] = '>';

					}
					else map[by][bx] = '>';
					flag = 4;
					break;
				case 'S':
					boomx = bx;
					boomy = by;
					while(true) {
						if(flag == 1) {
							System.out.println(boomx +" "+ boomy);
							if (boomy-1 >= 0 && (map[boomy-1][boomx] == '*' || map[boomy-1][boomx] == '#')) {
								if(map[boomy-1][boomx] == '*') {
									map[boomy-1][boomx] = '.';	
								}				
								break;
							}
							else if(boomy-1 < 0) break;
							else boomy--;
						}
						if(flag == 2) {
							if (boomy+1 < H &&( map[boomy+1][boomx] == '*' || map[boomy+1][boomx] == '#')) {
								if(map[boomy+1][boomx] == '*') {
									map[boomy+1][boomx] = '.';
								}

								break;
							}
							else if(boomy+1 >= H) break;
							else  boomy++;
						}
						//
						if(flag == 3) {
							if (boomx-1 >= 0 &&(map[boomy][boomx-1] == '*'|| map[boomy][boomx-1] == '#') ){
								if(map[boomy][boomx-1] == '*') map[boomy][boomx-1] = '.';
								break;
							}
							else if(boomx-1 < 0) break;
							else boomx--;
							//
						}
						if(flag == 4) {
							//System.out.println(boomx +" "+ boomy);
							if (boomx+1 < W &&( map[boomy][boomx+1] == '*'|| map[boomy][boomx+1] == '#')) {
								if( map[boomy][boomx+1] == '*') map[boomy][boomx+1] = '.';
								break;
							}
							else if(boomx+1 >= W) break;
							else  boomx++;
						}

					}
					break;

				}
			}

			sb.append("#"+t+" ");
			for(int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
