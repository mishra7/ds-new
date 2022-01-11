package com.ds;

public class AreaOfHistogram {

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxAreaOfRect(a));
    }

    public static int maxAreaOfRect(int a[]) {
        int aSize = a.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<aSize; i++) {
            int l = i , r = i ;

            while (l-1 >= 0 && a[l-1] >= a[i]) {
                l--;
            }
            while (r+1 < aSize && a[r+1] >= a[i]) {
                r++;
            }
            int area = (r - l + 1) * a[i];

            if (max < area) {
                max = area;
            }

        }


        return max;
    }

}
