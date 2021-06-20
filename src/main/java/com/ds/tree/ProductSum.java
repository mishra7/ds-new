package com.ds.tree;

class Solution2 {
    public int[] productExceptSelf(int[] a) {


        int size = a.length;
        int left[] = new int [size];
        int right[] =new int[size];
        int result[]= new int[size];

        for(int i =0; i<size ;i++){
            if(i == 0){
                left[i]=1;
            }else{
                left[i]= left[i-1]*a[i-1];
            }

        }
        for(int i =size-1; i>=0 ;i--){
            if(i == size-1){
                right[i]=1;
            }else{
                right[i]= right[i+1]*a[i+1];
            }

        }

        for(int i=0 ;i<size;i++){

            result[i] = left[i]*right[i];

        }

        return result;
    }
}