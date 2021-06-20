package com.ds;

public class TestArraySum {


    public static Integer maxSum(Integer a[]) {
        int result =0;
        int currentSum = -10;

        Integer resultSum[] = new Integer[a.length];

        //  [-2,1,-3,4,-1,2,1,-5,4]
        /* Rough
        -2      -2 >currentSum
        currentSum =-2   resu[-2 ,..]
        1+currentSum >current

        // -2 -44  -2
        // 1
        //
        // -2  1   -2 4  3 5 6




*/
        for (int i = 0; i < a.length; i++) {

            if (a[i] + currentSum > a[i]) {
                currentSum = a[i] + currentSum;
                a[i] = currentSum;

            }  else if( currentSum < a[i]){
                 currentSum =a[i];
            }


        }

        for(int i=0 ;i<a.length ;i++){
            if(a[i]>result){
                result =a[i];
            }
        }

   return  result;
    }

    public static void main(String[] args) {

        Integer a[] = {5,-2,1,-3,4,-1,2,1,-5,4 ,5};
        System.out.println(maxSum(a));
    }

}
