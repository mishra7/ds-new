package com.ds.str;

public class TripletSum {

    public static void main(String[] args) {
        int a[] = {1,9,4,7,8};
        tripletzsum(a,13);
    }


    public static void tripletzsum(int a[], int targetSum){
        int size = a.length;
        for(int i=0;i<size;i++) {
            int yz=targetSum - a[i];
            for(int j=0 ;j<size;j++){
                int y=yz- a[j];
                if(i!=j) { 
                    for (int k = 0; k < size; k++) {
                        if(k!=j){
                            if(a[k]== y){
                                System.out.println("{"+a[i]+","+a[j]+","+a[k]+"}");
                            }
                        }
                    }
                }
            }
        }

    }

}
