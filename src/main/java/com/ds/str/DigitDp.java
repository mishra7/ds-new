package com.ds.str;

public class DigitDp {


    public static int solve(String num, int numOfDigit, int sum, boolean tight) {
        if (sum < 0) {
            return 0;
        }

        if (numOfDigit == 1) {

            if (sum >= 0 && sum <= 9) {
                return 1;
            }

            return 0;
        }

        int answer = 0;
        int up = tight ? (Integer.parseInt(num.charAt(num.length() - numOfDigit) + "")) : 9;
        for (int digit = 0; digit <= up; digit++) {
            answer += solve(num, numOfDigit - 1, sum - digit, tight && (digit == up));
        }

        return answer;

    }

    public static void main(String[] args) {
        String num = "99";
        System.out.println(solve(num, num.length(), 9, true));

    }
}
