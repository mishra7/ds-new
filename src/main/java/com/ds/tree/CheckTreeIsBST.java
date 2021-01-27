package com.ds.tree;

public class CheckTreeIsBST {

    public static boolean isBST(Node root, Integer min, Integer max) {

        if (null == root) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }
}
