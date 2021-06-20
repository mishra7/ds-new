package com.ds.tree;

public class KthLargestInBST {

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.add(10);
        bst.add(4);
        bst.add(20);
        bst.add(2);
        bst.add(5);
        bst.add(15);
        bst.add(40);
        bst.print();
        KthLargestInBST kthLargestInBST = new KthLargestInBST();
        System.out.println( kthLargestInBST.findKthLargestInBST(bst.getRoot(),5));

    }

     int highest=0;

    public  int findKthLargestInBST(Node root ,int k){

        if(null == root){
            return -1;
        }
        if(null == root.left && null == root.right){
             highest++;
            return root.getData();
        }

        int right =  findKthLargestInBST(root.right,k);
        if(highest == k){
            return right;
        }
        highest++;
        if(highest == k){
            return root.data;
        }

        int left = findKthLargestInBST(root.left,k);

        if(highest == k){
            return left;
        }
        return -1;
    }

}
