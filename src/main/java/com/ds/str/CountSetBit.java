package com.ds.str;

public class CountSetBit {


    public static void main(String[] args) {
        System.out.println(countSetBit(3));
    }

    public static Integer countSetBit(Integer num) {
        Integer count = 0;

        while (num > 0) {

           count += num & 1;
           num = num >> 1;

        }
        return count;
    }
}
