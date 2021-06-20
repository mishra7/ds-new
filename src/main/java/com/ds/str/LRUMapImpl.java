package com.ds.str;

import com.ds.tree.LinkNode;

import java.util.HashMap;
import java.util.Map;

public class LRUMapImpl implements LRUCache {
    private final Integer capacity;
    private Integer currentCount = 0;
    Map<String, NodeLink> map = null;
    NodeLink head;
    NodeLink tail;

    public LRUMapImpl() {
        this.capacity = CAPACITY;
        new HashMap<String, LinkNode>(CAPACITY);

    }

    public LRUMapImpl(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<String, NodeLink>(capacity);

    }

    @Override
    public void put(String key, String value) {
        NodeLink newNode = new NodeLink(key, value);
        if (currentCount < capacity) {
            if (head == null) {
                head = newNode;
            }
        } else {
            map.remove(head.getKey());
            NodeLink temp = head.getNext();
            temp.setPrev(null);
            head.setNext(null);
            head.setPrev(null);
            head = temp;

        }
        if (tail != null) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        currentCount++;
        map.put(key, newNode);
    }

    @Override
    public String get(String key) {
        NodeLink currentNode = map.get(key);
        if (null != currentNode) {
            NodeLink tempPrev = currentNode.getPrev();
            NodeLink tempNext = currentNode.getNext();
            if (currentNode != head) {
                tempPrev.setNext(tempNext);
                tempNext.setPrev(tempPrev);
            } else {
                tempNext.setPrev(null);
                head = tempNext;
            }
            currentNode.setPrev(tail);
            currentNode.setNext(null);
            tail.setNext(currentNode);
            tail = currentNode;
            return currentNode.getValue();
        }

        return null;
    }

    public Map<String, NodeLink> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "LRUMapImpl{" +
                "capacity=" + capacity +
                ", map=" + map +
                ", currentCount=" + currentCount +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
