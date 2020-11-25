package com.ds.str;

import com.ds.str.exception.ZeroOrMaxCapacityCrossedError;

import java.util.*;

public class ProrityQuqueImpl {

    private Integer[] items;

    @Override
    public String toString() {
        return "ProrityQuqueImpl{" +
                "items=" + Arrays.toString(items) +
                ", counter=" + counter +
                ", capacity=" + capacity +
                ", current=" + current +
                '}';
    }

    private Integer counter = 0;
    private Integer capacity = 10;
    private Integer current = 0;

    public ProrityQuqueImpl(Integer capacity) {
        this.capacity = capacity;
        this.items = new Integer[capacity];

    }

    public boolean add(Integer item) {
        if (counter == capacity) {
            throw new ZeroOrMaxCapacityCrossedError("Queue is Full or Empty");
        }
        if (current == 0) {
            items[current] = item;
            counter++;
            current++;
            return true;
        } else {
            items[current] = item;
            int parent = current + 1;
            int child = current;
            while (parent > 1) {
                parent = parent / 2;
                if (items[parent - 1].compareTo(item) == -1) {
                    break;
                } else {
                    Object temp = item;
                    items[child] = items[parent - 1];
                    items[parent - 1] = item;
                    child = parent - 1;

                }

            }
            counter++;
            current++;
            return true;
        }


    }

    public int remove() {
        int result = items[0];
        items[0] = items[counter - 1];
        items[counter - 1] = null;
        counter--;
        int k = 1;
        while (items[k - 1] != null) {
            int left = 2 * k;
            int right = 2 * k + 1;
            int temp = items[k - 1];
            boolean isExit = true;
            if (left - 1 <= capacity) {
                int rightValue = (right - 1 <= items.length - 1 && null != items[right - 1]) ? items[right - 1] : Integer.MAX_VALUE;

                if (null != items[left - 1] && items[left - 1] < rightValue && items[left - 1] < items[k - 1]) {
                    items[k - 1] = items[left - 1];
                    items[left - 1] = temp;
                    k = left;
                    isExit = false;
                } else if (Integer.MAX_VALUE != rightValue && null != items[right - 1] && items[right - 1] < items[left - 1] && items[right - 1] < items[k - 1]) {
                    items[k - 1] = items[right - 1];
                    items[right - 1] = temp;
                    k = right;
                    isExit = false;
                }
                if (isExit) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {9, 5, 34, 21, 89, 4};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer a : arr) {
            pq.add(a);
        }
        System.out.println(pq);
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            // System.out.println("hi");
            System.out.println(pq.remove());
            if (pq.size() == 2) {
                System.out.println(pq);
                break;
            }
        }


    }

    Map<String, PriorityQueue<KeyCount>> map = new HashMap<>();
    PriorityQueue<KeyCount> pq;
    public void visted(String treeId, String  node) {
         if(map.containsKey(treeId)){
             pq = map.get(treeId);
             KeyCount key = new KeyCount();
             key.setCount(0);
             if(pq.contains(key)){
               //  KeyCount keyCount =pq.remove(key);
             }
             //pq.add()
         }

    }


}

class KeyCount implements Comparable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyCount keyCount = (KeyCount) o;
        return Objects.equals(key, keyCount.key) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    private String key;
    private Integer count;


    public String getKey() {
        return key;
    }

    public KeyCount setKey(String key) {
        this.key = key;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public KeyCount setCount(Integer count) {
        this.count = count;
        return this;
    }


    @Override
    public int compareTo(Object o) {
        KeyCount keyCount = (KeyCount) o;

        return keyCount.getCount() - this.getCount();
    }


}


