package com.ds.str;

import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {

        LRUMapImpl lruCache = new LRUMapImpl(4);
        lruCache.put("A", "A");
        lruCache.put("B", "B");
        lruCache.put("C", "C");
        lruCache.put("D", "D");
        lruCache.get("A");
        lruCache.get("B");
        print(lruCache.getMap());
        System.out.println("----------------------");
        lruCache.put("E", "E");
        lruCache.put("F", "F");
        print(lruCache.getMap());


    }

    public static  void print(Map<String,NodeLink> map) {

        for (Map.Entry<String, NodeLink> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value :" + entry.getValue().getValue());

        }
    }
}
