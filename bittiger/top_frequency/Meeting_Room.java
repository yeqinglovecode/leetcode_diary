package iv;

import java.io.*;
import java.util.*;
//use greedy algorithm to solve this problem
class Event implements Comparable<Event>{
	int t; //time
	int state; //i begin or -1 end
	Event(int t, int state){
		this.t = t;
		this.state = state;
	}
	
	@Override
	public int compareTo(final Event temp){
		if(t==temp.t) return Integer.compare(state, temp.state);
		else return Integer.compare(t, temp.t);
	}
}
	

public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			Event[] timeline = new Event[n*2];
			for(int i=0; i<n; i++){
				timeline[i*2] = new Event(in.nextInt(),1);
				timeline[i*2+1] = new Event(in.nextInt(), -1);
			}
			Arrays.sort(timeline);
			int result = 0;
			int count = 0;
			for(int i=0; i<timeline.length; ++i){
				count+=timeline[i].state;
				if(count>result) result = count;
			}
			System.out.println(result);
			n = in.nextInt();
		}
		in.close();
	}
}



