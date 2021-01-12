package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

public class PrintDiagonalElementsSum {
	static Map<Integer,Integer> map=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node one=new Node(1);
		Node two=new Node(2);
		Node three=new Node(3);
		Node four=new Node(4);
		Node five=new Node(5);
		Node six=new Node(6);
		Node seven=new Node(7);
		Node eight=new Node(8);
		Node nine=new Node(9);
		Node ten=new Node(10);
		Node eleven=new Node(11);
		Node twelve=new Node(12);

		one.left=two;
		one.right=three;
		three.right=five;
		three.left=four;
		four.left=twelve;
		four.right=seven;
		two.left=nine;
		two.right=six;
		nine.right=ten;
		six.left=eleven;

		printDiagonalSum(one,0);
		System.out.println(""+map);
	}

	public static Node printDiagonalSum(Node root, int diagonalId) {
		if(root==null)
			return root;


		if(!map.containsKey(diagonalId)) {
			map.put(diagonalId,root.data);
		}
		else {
			map.put(diagonalId,map.get(diagonalId)+root.data);
		}

		if(null!=root.left) {

			printDiagonalSum(root.left,diagonalId+1);  

		}

		if(null!=root.right) {

			printDiagonalSum(root.right,diagonalId); 

		}


		return root;

	}

}
