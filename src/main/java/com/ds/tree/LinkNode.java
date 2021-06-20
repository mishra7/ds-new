package com.ds.tree;

public class LinkNode {
    LinkNode next;
    Integer data;

    public LinkNode(int data) {
        this.data = data;
        this.next = null;

    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }


}
