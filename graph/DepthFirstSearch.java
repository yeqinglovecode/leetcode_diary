package iv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

class Graph{
	private int V;
	private HashMap<Integer, List<Integer>> adj;
	//constructor
	Graph(int v){
		//initialize the hashmap
		V = v;
		adj = new HashMap<Integer, List<Integer>>();
	}
	
	public void addEdge(int s, int d){
		List<Integer>list;
		if(adj.containsKey(s)){
			list = adj.get(s);
			list.add(d);
			adj.put(s, list);
		}else{
			list = new ArrayList<Integer>();
			list.add(d);
			adj.put(s, list);
		}
	}
	
	public void printGraph(){
		for(Integer key :  adj.keySet()){
			System.out.print(key + ":");
			for(Integer value : adj.get(key)){
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	//conducts a breadth-first traversal from a starting point s
	public void BFS(int s){
		boolean[] visited  = new boolean[V];
		
		LinkedList<Integer>queue = new LinkedList<Integer>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size()!=0){
			s = queue.poll();
			System.out.print(s + " ");
			
			//Get all the adjacent nodes of s
			//if unvisited, mark it as visited and enqueue it
			List<Integer>list = adj.get(s);
			for(Integer integer : list){
				if(!visited[integer]){
					visited[integer] = true;
					queue.add(integer);
				}
			}
		}
	}
	//This function conducts a Depth-First-Search traversal starting from v
	//The function uses a recursive DFSUtil()
	public void DFS(int v){
		boolean[] visited = new boolean[V];
		DFSUtil(v, visited);
	}
	public void DFSUtil(int v, boolean[] visited){
		visited[v]=true;
		System.out.print(v+" ");
		
		List<Integer>list = adj.get(v);
		for(Integer n : list){
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}
		
	}
}

public class MyGraph {
	
	public static void main(String[] args){
		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		//g.printGraph();
        g.DFS(2);
	}
}
