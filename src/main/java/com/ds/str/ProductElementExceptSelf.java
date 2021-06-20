package com.ds.str;

public class ProductElementExceptSelf {


    public static void main(String[] args) {
         Integer input[] = {1 ,3,2,4};
         for(Integer output :productElementsExceptSelf(input)){
             System.out.print(output +" ");
         }


    }

    public static Integer[] productElementsExceptSelf(Integer input[]) {


        Integer result[] = new Integer[input.length];
        int left = 1;
        int right =1;
        for (int i = 0; i < input.length; i++) {
            result[i] = left;
            left = left * input[i];

        }
        for (int i=input.length-1; i>=0 ;i--){
            result[i]=result[i]*right;
            right= right*input[i];
        }
        return result;
    }

}
