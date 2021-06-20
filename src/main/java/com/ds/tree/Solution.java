package com.ds.tree;

class Solution {
    public static int numTeams(int[] a) {

        int size = a.length;
        int teamCount = 0;

        for (int i = 1; i < size - 1; i++) {

            int smallest = 0;
            int biggest = 0;
            int cuurentValue = a[i];

            for (int j = i -  1; j >= 0; j--) {
                if (cuurentValue > a[j]) {
                    smallest++;
                }
            }

            for (int j = i + 1; j < size; j++) {
                if (a[j] > cuurentValue) {
                    biggest++;
                }
            }
            teamCount += smallest * biggest;
            smallest = 0;
            biggest = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (cuurentValue < a[j]) {
                    biggest++;
                }
            }

            for (int j = i + 1; j < size; j++) {
                if (a[j] < cuurentValue) {
                    smallest++;
                }
            }
            teamCount += smallest * biggest;
        }

        return teamCount;
    }

    public static void main(String[] args) {
        int a[] = {2, 5, 3, 4, 1};
        System.out.println(numTeams(a));
    }
}
