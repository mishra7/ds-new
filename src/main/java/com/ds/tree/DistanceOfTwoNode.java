package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfTwoNode {

    public Integer findDistBtwnNodes(Node root, Integer a, Integer b) {
        LCAInTree lca = new LCAInTree();
        Node lcaNode = lca.findLca(root, a, b);
        return (findDistance(lcaNode,a) )+ (findDistance(lcaNode,b));


    }

    Integer findDistance(Node lca, Integer a) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(lca);
        queue.add(null);
        int d = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (null != temp && temp.getData() == a) {
                return d;
            } else if (null != temp) {
                if (null != temp && temp.getLeft() != null)
                    queue.add(temp.getLeft());
                if (null != temp && temp.getRight() != null)
                    queue.add(temp.getRight());
            } else {
                d++;
                queue.add(null);
            }
        }
        return 0;

    }
}
