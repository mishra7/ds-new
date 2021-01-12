package com.ds.tree;

public class LCAInTree {

    public Node findLca(Node root, Integer a, Integer b) {
        if (null == root) {
            return root;
        }
        if (root.getData() == a || root.getData() == b) {
            return root;
        }
        Node left = findLca(root.getLeft(), a, b);

        Node right = findLca(root.getRight(), a, b);

        if (left == null && right == null) {
            return null;
        }

        if (null != left && null != right) {
            return root;
        }

        return left == null ? right : left;
    }
}
