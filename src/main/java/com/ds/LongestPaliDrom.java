package com.ds;

public class LongestPaliDrom {

    public static void main(String[] args) {
        System.out.println(longestPaliDrom("cbbd"));
    }

    public static String longestPaliDrom(String str){

        char c[] = str.toCharArray();

        int size = c.length;
        int startMax=0;
        int max =-1;
        for (int i =0 ; i<size-1; i++){
            int l,r;

            if((size%2==0)){
                l=i;
                r=i+1;
            }else {
                l=r=i;

            }
            while (l>=0  && r<size && c[l]==c[r]){
                l--;
                r++;
            }


            if(max<(r-l-1)){
                max =r-l-1;
                startMax = l+1;
            }
        }

        return str.substring(startMax,startMax+ max);
    }
}
