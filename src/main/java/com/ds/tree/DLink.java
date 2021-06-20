package com.ds.tree;

public class DLink {

    DLink prev;

    @Override
    public String toString() {
        return "DLink{" +
                "prev=" + prev +
                ", next=" + next +
                ", data=" + data +
                '}';
    }

    DLink next;
    Integer data;

    public DLink() {
    }

    public DLink(Integer data) {
        this.data = data;
    }

    public DLink getPrev() {
        return prev;
    }

    public void setPrev(DLink prev) {
        this.prev = prev;
    }

    public DLink getNext() {
        return next;
    }

    public void setNext(DLink next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
