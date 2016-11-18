package iv;

import java.io.*;
import java.util.*;
/* version one
class Perfect{
	int search(int n){
		//input: n
		//output: the MIN number of perfect numbers
		int result = n;
		for(int i=1; i*i<=n; ++i){
			int temp = search(n-i*i);
			if(temp+1<result) result = temp+1;
		}
		return result;
	}
}*/
/* 
class Perfect{
	HashMap<Integer, Integer>cache;
	Perfect(){
		cache = new HashMap<Integer, Integer>();
	}
	int search(int n){
		//input: n
		//output: the MIN number of perfect numbers
		if(cache.containsKey(n)) return cache.get(n);
		int result = n;
		for(int i=1; i*i<=n; ++i){
			int temp = search(n-i*i);
			if(temp+1<result) result = temp+1;
		}
		cache.put(n, result);
		return result;
	}
}
*/
/* solve stack overflow
class Perfect{
	HashMap<Integer, Integer>cache;
	Perfect(){
		cache = new HashMap<Integer, Integer>();
	}
	int search(int n){
		//input: n
		//output: the MIN number of perfect numbers
		if(cache.containsKey(n)) return cache.get(n);
		int result = n;
		int ceiling = (int)Math.pow(n, 0.5);
		for(int i=ceiling; i>0; --i){
			int temp = search(n-i*i);
			if(temp+1<result) result = temp+1;
		}
		cache.put(n, result);
		return result;
	}
}
*/

/*ceiling cut edges
class Perfect{
	HashMap<Integer, Integer>cache;
	Perfect(){
		cache = new HashMap<Integer, Integer>();
	}
	int search(int n){
		//input: n
		//output: the MIN number of perfect numbers
		if(cache.containsKey(n)) return cache.get(n);
		int result = n;
		int ceiling = (int)Math.pow(n, 0.5);
		if(ceiling*ceiling==n) result = 1;
		else{
			for(int i=ceiling; i>0; --i){
				int temp = search(n-i*i);
				if(temp+1<result) result = temp+1;
				if(temp==1) break;
			}
		}
		cache.put(n, result);
		return result;
	}
}
 */
/*
 * depth cut edge
 */
class Perfect{
	HashMap<Integer, Integer>cache;
	int best;
	Perfect(){
		cache = new HashMap<Integer, Integer>();
	}
	int search(int n, int depth){
		//input: n
		//output: the MIN number of perfect numbers
		if(depth>best) return -1;//short cut
		if(cache.containsKey(n)) return cache.get(n);
		int result = -1;
		int ceiling = (int)Math.pow(n, 0.5);
		if(ceiling*ceiling==n) {
			result = 1;
			if(depth<best) best = depth;
		}
		else{
			for(int i=ceiling; i>0; --i){
				int temp = search(n-i*i, depth+1);
				if(temp==-1) continue;
				
				if(result==-1 || temp+1<result) result=temp+1;
				if(temp+depth<best) best = temp+depth;
				if(temp==1) break;
			}
		}
		if(result!=-1) cache.put(n, result);
		return result;
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
			System.out.print(n+" RESULT: "+perfect.search(n,1));
			long end = System.nanoTime();
			System.out.println(" TIME: "+(end-start)/1000000+"ms");
		}
		in.close();
	}
}



