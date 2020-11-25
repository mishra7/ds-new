package com.ds.str;

import java.util.Map;
import java.util.TreeMap;

public class StringPremutation {

    public void permuteString(String word) {

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, (map.get(ch) + 1));
            } else {
                map.put(ch, 1);
            }
        }
        int size = map.size();
        int count[] = new int[size];
        char str[] = new char[size];
        char result[] = new char[word.length()];
        int i=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {


        }

    }

}
