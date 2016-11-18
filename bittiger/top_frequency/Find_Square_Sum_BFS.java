package iv;

import java.io.*;
import java.util.*;

class Perfect{
	int bfs(int n){
		LinkedList<Integer>processing = new LinkedList<Integer>();
		processing.add(n);
		processing.add(-1);
		
		HashSet<Integer> used = new HashSet<Integer>();
		
		int need = 1;
		
		while(processing.isEmpty()==false){
			int temp = processing.pollFirst();
			if(temp<0){
				processing.addLast(temp-1);
				need++;
			}else{
				int ceiling = (int)Math.pow(temp, 0.5);
				if(ceiling*ceiling==temp) break;
				
				for(int i=ceiling; i>0; --i){
					if(used.add(temp-i*i)) processing.addLast(temp-i*i);
				}
			}
		}
		return need;
	}
}



public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			long start = System.nanoTime();
			
			Perfect perfect = new Perfect();
			//System.out.print(n+" RESULT: "+perfect.search(n));
			System.out.print(n+" RESULT: "+perfect.bfs(n));
			long end = System.nanoTime();
			System.out.println(" TIME: "+(end-start)/1000000+"ms");
		}
		in.close();
	}
}



