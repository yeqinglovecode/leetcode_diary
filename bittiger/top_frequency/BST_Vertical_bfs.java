package iv;

import java.io.*;
import java.util.*;
class Node implements Comparable<Node>{
	int value;
	int id;
	int column;
	
	@Override
	public int compareTo(final Node temp){
		if(column == temp.column) return Integer.compare(id, temp.id);
		else return Integer.compare(column, temp.column);
	}
}


public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			Node[] tree = new Node[n];
			for(int i=0; i<n; ++i) tree[i] = new Node();
			tree[0].column = 0;
			for(int i=0; i<n; i++){
				tree[i].value = in.nextInt();
				tree[i].id=i;
				int leftID= in.nextInt();
				
				if(leftID!=-1) tree[leftID].column = tree[i].column-1;
				int rightID = in.nextInt();
				if(rightID!=-1) tree[rightID].column = tree[i].column+1;
 			}
			Arrays.sort(tree);
			for(int i=0; i<n; ++i) System.out.print(tree[i].value+ " ");
			System.out.println();
			
			n=in.nextInt();
		}
		in.close();
	}
}



