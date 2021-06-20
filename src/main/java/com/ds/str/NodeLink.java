package com.ds.str;

import com.ds.tree.LinkNode;

public class NodeLink {

    private String key;
    private String value;
    private NodeLink next;
    private NodeLink prev;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public NodeLink(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeLink getNext() {
        return next;
    }

    public void setNext(NodeLink next) {
        this.next = next;
    }

    public NodeLink getPrev() {
        return prev;
    }

    public void setPrev(NodeLink prev) {
        this.prev = prev;
    }


}
