package BOJ4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.StringTokenizer;
//#4949.균형잡힌세상
//
//
//
//
class MyStack{	 
    private Node top;
 
    public MyStack(){
        this.top = null;
    }
 
    public class Node {
        private String data; // push할 데이터
        private Node nextNode;//다음 노드 객체의 주소
 
        public Node(String data) {
            this.data = data;
            this.nextNode = null;
        }
 
    }
 
    public String push(String data) {
        Node node = new Node(data);
        node.nextNode = top;
    
        top = node;
        
        return data;
    }
 
    public String pop() {
        String data = peek();
        
        top = top.nextNode;        
        return data;
    }
 
    public String peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }
 
    public boolean empty() {
        return top == null;
    }
 
    public int search(Object o) {
        int index = 1;
        Node tempTop = top;
        
        while (tempTop != null) {
            if (tempTop.data.equals(o))
                return index;                
            tempTop = tempTop.nextNode;
            
            index++;
        }
 
        return -1;
    }
 
}


public class N4949 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LinkedList<MyStack> list = new LinkedList<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while(s.length() <= 100) {
			s += bf.readLine();
			for(int i = 0 ; i < s.length(); i++) {
				
			}
			StringTokenizer st = new StringTokenizer(s);
			
			//list.push(s.split(" "));
		}
		
		
		
		

	}
}


