package iv;

import java.io.*;
import java.util.*;
//greedy
//use heap to store the classes can be taken, select the smallest one everytime
class Node{
	LinkedList<Integer>requests;
	int count;
	int id;
	
	Node(int id){
		requests = new LinkedList<Integer>();
		count = 0;
		this.id = id;
	}
}



public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			Node[] tree = new Node[n];
			for(int i=0; i<n; ++i) tree[i] = new Node(i);
			
			int m=in.nextInt();
			while(m--!=0){
				int front = in.nextInt();
				int back = in.nextInt();
				tree[back].requests.add(front);
				++tree[front].count;
			}
			PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
			for(int i=0; i<n; ++i){
				if(tree[i].count==0) pq.add(i);
			}
			while(pq.isEmpty()==false){
				int id = pq.poll();
				System.out.print(id+" ");
				for(Integer father: tree[id].requests){
					--tree[father].count;
					if(tree[father].count==0) pq.add(father);
				}
			}
			System.out.println();
			n = in.nextInt();
		}
		in.close();
	}
}



