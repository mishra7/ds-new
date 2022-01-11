package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TestConc {

    public static void main(String[] args) {
        TestConc t = new TestConc();
        List<int[]> result =t.dedup(Arrays.asList(new int[]{1, 2, 3}, new int[]{3, 2, 1}, new int[]{1, 2}, new int[]{1, 2, 3}));

        for (int i=0; i<result.size();i++) {
            int a[] =result.get(i);
            for (int j=0; j<result.size();j++){
                System.out.print(a[j] +" ");
            }
            System.out.println();

        }

    }

    public List<int[]> dedup(List<int[]> list) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                int r = Arrays.compare(list.get(i), list.get(j));
                if (r == 0) {
                    result.add(list.get(i));
                    list.set(j, null);
                }
            }

        }


        return result;

    }


}
