package com.ds;

public class ArraySum {
    public static void main(String[] args) {
        int a[]={1,1,3,2,2,2,1,5,1,5};
        System.out.println(maxSumMinProduct(a));
    }
    public static int maxSumMinProduct(int[] a) {

        int size = a.length;
        int max = Integer.MIN_VALUE;
        int min=Integer.MIN_VALUE;


        for(int i=0;i<size;i++){
            int sum =0;
            min=a[i];
            int p=0;
            int c=0;
            for(int j=i ;j<size;j++){

                if(min>a[j]){
                    min  =a[j];
                }
                sum+=a[j];
                if(i==j){
                    p=1*sum;
                    ;
                }else{
                    p=min*(sum);
                }


                if(max<p){
                    max=p;
                }
            }
        }

        return max;
    }
}