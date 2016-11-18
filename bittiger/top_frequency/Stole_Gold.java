package iv;

import java.io.*;
import java.util.*;

class Street{
	int[] houses;
	HashMap<Integer, Integer>cache;
	
	Street(int[] houses){
		this.houses = houses;
		cache = new HashMap<Integer, Integer>();
	}
	int findResult(int pos, int count){//pos计算到哪个房子了，count前面连续偷了几个房子
		if(pos==houses.length) return 0;
		
		//check cache
		if(cache.containsKey(3*pos+count)) return cache.get(3*pos+count);
		//case 1不偷这个房子
		int butou = findResult(pos+1,0);
		int tou = 0;
		if(count<2){
			tou = houses[pos]+findResult(pos+1, count+1);
		}
		
		cache.put(3*pos+count, Math.max(tou, butou));
		return cache.get(3*pos+count); //在前面选择了count个房子时，从pos到结尾能够偷取的最大值
		
	}
}

public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			int[] houses = new int[n];
			for(int i=0; i<n; ++i){
				houses[i] = in.nextInt();
			}
			Street street = new Street(houses);
			System.out.println(street.findResult(0, 0));
			n = in.nextInt();
		}
		in.close();
	}
}



