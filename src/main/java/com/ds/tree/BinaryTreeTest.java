package com.ds.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.add(9);
        System.out.println(bt);
        bt.print();

        LCAInTree lca = new LCAInTree();
        System.out.println(lca.findLca(bt.getRoot(),6,9).data);
        DistanceOfTwoNode distance = new DistanceOfTwoNode();
        System.out.println("Distance******************");
        System.out.println(distance.findDistBtwnNodes(bt.getRoot(), 1,4));



    }
}
