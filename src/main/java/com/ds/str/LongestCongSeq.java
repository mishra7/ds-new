package com.ds.str;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class LongestCongSeq {


    public static List<Integer> longConsSeq(int ar[]) {
        Map<Integer, Integer> set = new ConcurrentHashMap<>();
        List<Integer> result = new ArrayList<>();
        Integer max = 0;
        for (int n : ar) {
            set.put(n, 0);
        }
        Iterator<Integer> itr = set.keySet().iterator();
        while (!set.isEmpty()) {

            List listInt = new ArrayList<>();
            Integer d = itr.next();

            set.remove(d);
            Integer lb = d - 1;

            while (set.containsKey(lb)) {
                listInt.add(lb);
                set.remove(lb);
                lb = lb - 1;
            }
            Integer ub = d + 1;
            listInt.add(d);
            while (set.containsKey(ub)) {
                listInt.add(ub);
                set.remove(ub);
                ub = ub + 1;
            }
            if ((ub - lb - 1) > max) {
                max = ub - lb - 1;
                result = listInt;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {100, 7, 9, 4, 11, 3, 2, 5, 1};
        List<Integer> m = longConsSeq(a);
        Collections.sort(m);
        System.out.println(" longest cons seq size : " + m.size() + " lcs :" + m);

    }

}
