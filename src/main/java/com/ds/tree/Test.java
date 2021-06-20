package com.ds.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws IOException {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer numLine = Integer.parseInt(br.readLine());                // Reading input from STDIN
        System.out.println(numLine);   // Writing output to STDOUT
    int arr[] = new int[numLine];

        for( int i=0; i<numLine ;i++ ){
        Integer input = Integer.parseInt(br.readLine());
        arr[i]=input;
    }




    // Write your code here

        System.out.println("Output");

        for(int i= 0 ;i<numLine; i++){
        FindXAndprint(arr[i]);
    }




}

    public static void FindXAndprint(int k ){
        int factorSum = 0;
        for(int i =1 ; i<=k; i++){
            int countFactor =0;
            for (int j =1 ; j<=i ; j++){

                if(i%j==0){
                    countFactor++;
                }

            }
            factorSum =factorSum +countFactor;
            if(factorSum>=k){
                System.out.println(i);
                break;
            }

        }

    }
}
