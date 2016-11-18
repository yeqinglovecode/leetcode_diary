package iv;

import java.io.*;
import java.util.*;
class Node{
	int value;
	Node next;
	Node(){
		next = null;
	}
}
class Iteration{
	public Node reverse(Node head){
		Node pre = null;
		Node current = head;
		Node next = null;
		
		while(current!=null){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
	public void display(Node head){
		while(head!=null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}
}

class Recursion{
	public Node reverse(Node head){
		if(head == null || head.next==null) return head;
		
		Node newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}

public class tryplay{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		int n = in.nextInt();
		while(n!=-1){
			Node head = null;
			Node pre = null;
			while(n--!=0){
				Node temp = new Node();
				temp.value = in.nextInt();
				
				if(head==null) head = temp;
				else pre.next = temp;
				pre = temp;
			}
			Iteration itr = new Iteration();
			itr.display(head);
			
			head = itr.reverse(head);
			itr.display(head);
			n = in.nextInt();
		}
		in.close();
	}
}



