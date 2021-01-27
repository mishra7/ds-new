package com.ds.tree;

public class ChckTreeBSTTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(10);
        bt.add(6);
        bt.add(11);
        bt.add(7);
        bt.add(8);
        bt.print();

        System.out.println(CheckTreeIsBST.isBST(bt.getRoot() ,Integer.MIN_VALUE ,Integer.MAX_VALUE));


    }
}
