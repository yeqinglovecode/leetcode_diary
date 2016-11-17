package iv;

import java.io.*;
import java.util.*;
/* A direct way
class Fib{
	int get(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return get(n-1)+get(n-2);
	}
}
*/

/*
 * Using cache

class Fib{
	HashMap<Integer, Integer>cache;
	Fib(){
		cache = new HashMap<Integer, Integer>();
		cache.put(0,0);
		cache.put(1, 1);
	}
	int get(int n){
		if(cache.containsKey(n)) return cache.get(n);
		cache.put(n,  get(n-1)+get(n-2));
		return cache.get(n);
	}
}


public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		Fib fib = new Fib();
		
		int n= in.nextInt();
		while(n!=-1){
			System.out.println(fib.get(n));
			n = in.nextInt();
		}
		in.close();
	}
}
*/

/* Dynamic Programming
 * 
 */
public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		
		int n= in.nextInt();
		while(n!=-1){
			int result = 1;
			int pre = 0;
			if(n==0) result = 0;
			for(int i=2; i<=n; ++i){
				int temp = result;
				result +=pre;
				pre = temp;
			}
			System.out.println(result);
			n= in.nextInt();
		}
		in.close();
	}
}
