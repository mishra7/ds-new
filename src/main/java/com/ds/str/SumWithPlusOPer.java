package com.ds.str;

public class SumWithPlusOPer {

    public static int sum(int x, int y) {
        while (y > 0) {
            int temp = x & y;
            x = x ^ y;
            y = temp << 1;

        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println("sum :" +sum(9,8));
    }
}
