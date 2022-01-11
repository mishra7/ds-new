package com.ds;

public class Test {

    public static void main(String[] args) {
        System.out.println(reverse(11));
    }

    public static int reverse(int n){
        boolean isBitOn = false;
        int rev = 0;
        int j = 0;
        for (int i= 31;i>=0;i--){
            if(isBitOn){
                if((n & (1<<i))!=0) {
                    rev =rev|1<<j;
                    j++;
                } else{
                    j++;
                }

                } else {
                if((n & (1<<i))!=0){
                    isBitOn= true;
                   rev =rev|1;
                   j++;
                }else {

                }
            }

        }
      return rev;

    }
}
