package com.ds.tree;

public class DLinkedList {
    DLink head;
    DLink tail;

    public void add(Integer data) {
        if (null == head) {
            head = new DLink(data);
            tail = head;
        } else {
            DLink newNode = new DLink(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void print(){
        DLink currentNode = head;
        while (null != currentNode){
            System.out.print(currentNode.getData() +" , ");
            currentNode = currentNode.next;
        }
    }


}
