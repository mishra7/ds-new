package com.ds.str;

import java.util.LinkedList;

public class Test {


        public static int findTheWinner(int n, int k) {

            LinkedList<Integer> list = new LinkedList();
            int m =n;
            for(int i =1 ;i<=n ;i++){
                list.add(i);
            }
            int i =0;
            while(m>=1){
                Integer kk=k +i;
                if(m >=kk){
                    list.remove(kk);
                }
                else{
                    Integer diff=kk-n;
                    list.remove(diff);
                    i=diff-1;
                }
                m--;
                i++;


            }
            return list.remove();

        }


    public static void main(String[] args) {

        System.out.println(findTheWinner(5,3));

    }


}
