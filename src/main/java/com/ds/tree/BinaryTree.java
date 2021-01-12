package com.ds.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node head;
    Node p;
    Queue<Node> q;

    public BinaryTree() {
        q = new LinkedList<Node>();
        this.head = null;
        this.p = null;
    }

    public void add(Integer data) {
        addTree(data);
    }

    private Node addTree(Integer data) {
        Node temp = null;
        if (null == p) {
            p = new Node(data);
            head = p;
            return p;
        }
        if (null != p & p.getLeft() != null && p.getRight() != null) {
            p = q.poll();
        }
        temp = new Node(data);
        q.add(temp);
        if (null == p.getLeft()) {
            p.setLeft(temp);
        } else if (null == p.getRight()) {
            p.setRight(temp);
        }
        return temp;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "head=" + head +
                '}';
    }

    public void print() {
        HashMap<Integer, Integer> map = new HashMap();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        System.out.print(" " + head.getData() + " ");
        System.out.println();
        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            if (null != temp && null != temp.getLeft()) {
                System.out.print(" " + temp.getLeft().getData() + " ");
                queue.add(temp.getLeft());

            }
            if (null != temp && null != temp.getRight()) {
                System.out.print(" " + temp.getRight().getData() + " ");
                queue.add(temp.getRight());
            }
            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(null);
            }

        }

    }
    public Node getRoot() {
        return this.head;
    }

}
