package com.ds.str;

public class DigitDp {

 static int xx[][][] = new int[181][181][2];
    public static int solve(String num, int numOfDigit, int sum, boolean tight) {
        if (sum < 0) {
            return 0;
        }

        if (numOfDigit == 1) {

            if (sum >= 0 && sum <= 9) {
                xx[numOfDigit][sum][tight?1:0]=1;
                return 1;
            }

            return 0;
        }
        if(xx[numOfDigit][sum][tight?1:0]==1){
            return xx[numOfDigit][sum][tight?1:0];
        }

        int answer = 0;
        int up = tight ? (Integer.parseInt(num.charAt(num.length() - numOfDigit) + "")) : 9;
        for (int digit = 0; digit <= up; digit++) {
            answer += solve(num, numOfDigit - 1, sum - digit, tight && (digit == up));
        }

        return answer;

    }

    public static void main(String[] args) {
        String num = "22";
        System.out.println(solve(num, num.length(), 4, true));

    }
}
