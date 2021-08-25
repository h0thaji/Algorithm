package BOJ1713_후보추천하기;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static ArrayList<Student> candidate = new ArrayList<>();
	
	static class Student implements Comparable<Student>{
		int idx;
		int order;
		int recommend;
		
		public Student(int idx,int order, int recommend) {
			this.idx = idx;
			this.order = order;
			this.recommend = recommend;
		}

		@Override
		public int compareTo(Student o) {
			return this.idx-o.idx;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());
		int order = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int input = Integer.parseInt(st.nextToken());
			boolean check = false;
			for (Student s : candidate) {
				if(s.idx == input) {
					s.recommend++;
					check = true;
					break;
				}
			}
//			for (Student s : candidate) {
//				System.out.print(s.order);
//			}System.out.println();
			if(check) continue;
			if(candidate.size() == N) {
				Collections.sort(candidate,new Comparator<Student>(){

					@Override
					public int compare(Student o1, Student o2) {
						if(o1.recommend != o2.recommend) return o1.recommend - o2.recommend;
						else return o1.order - o2.order;
					}					
				});				
				candidate.remove(0);  
			}
			candidate.add(new Student(input,order++, 1));
			
			
		}
		
		Collections.sort(candidate);
		for (Student s : candidate) {
			sb.append(s.idx).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
				
		
	}

}
