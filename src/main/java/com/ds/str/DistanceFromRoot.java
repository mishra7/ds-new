package com.ds.str;
import java.util.*;

public class DistanceFromRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(1);
		Node rootLeft=new Node(2);
		Node rootRight=new Node(3);
		Node firstLeft=new Node(4);
		Node firstRight=new Node(5);
		
		root.left=rootLeft;
		root.right=rootRight;
		
		rootLeft.left=firstLeft;
		rootLeft.right=firstRight;
		
		Queue<Node> que=findKthLevelNodes(root,5);
	while(!que.isEmpty()) {
		Node temp=que.poll();
		if(null!=temp)
			System.out.println(temp.data);
	}
		
		
	}
	
	
	public static Queue<Node> findKthLevelNodes(Node root,int K) {
		
		Queue<Node> queue=new LinkedList<>();
		if(root==null)
			return null;
		
		
		queue.add(root);
		if(K==0 )
			return queue;
		queue.add(null); // identifier for level check
		int count=0;
		while(!queue.isEmpty()) {
			
			Node node=queue.poll();
			
			if(null!=node) {
				if(null!=node.left)
					queue.add(node.left);
				if(null!=node.right)
					 queue.add(node.right);
			}
			else {
				queue.add(null); 
				count++;
				
             if(count==K) {
					//System.out.println(queue.toString());
					return queue;
				}
				
			}
		}
		
		return queue;
	}

}
