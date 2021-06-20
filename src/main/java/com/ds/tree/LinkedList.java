package com.ds.tree;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    LinkNode head;
    LinkNode tail;
    public void add(Integer data) {
        if (null == head) {
            head = new LinkNode(data);
            tail = head;
        } else {
            tail.next = new LinkNode(data);
            tail = tail.next;
        }
    }

    public void print() {
        Set<LinkNode> set = new HashSet<>();
        while(null != head && (head.next != null || !set.contains(head.next))){
            set.add(head);
            System.out.print(head.data+ " ");
        }
    }


}
