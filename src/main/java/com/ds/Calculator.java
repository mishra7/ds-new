package com.ds;

import java.util.*;

public class Calculator {
    public static final char DIVIDE = '/';
    public static final char MULTIPLY = '*';

    public static void main(String[] args) {
        String exp = "3+2-4*2+9*2+8-5";
        System.out.println(evaluateExp(exp));
        System.out.println(3+2-4*2+9*2+8-5);
    }

    public static int evaluateExp(String exp) {
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if ('(' == ch) {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(ch - '0');

            } else if (')' == ch) {
                while ('(' != operator.peek()) {
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int r = operation(v1, v2, ch);
                    operand.push(r);
                }
                operator.pop();
            } else if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {
                while (operator.size() > 0 && operator.peek() != '(' && prcedence(ch) <= prcedence(operator.peek())) {
                    char tt  = operator.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int r = operation(v1, v2, tt);
                    operand.push(r);
                }
                operator.push(ch);
            }
        }
        while (!operator.isEmpty()) {
            char ch = operator.pop();
            int v2 = operand.pop();
            int v1 = operand.pop();
            int r = operation(v1, v2, ch);
            operand.push(r);
        }


        return operand.peek();
    }

    private static int prcedence(char ch) {
        if ('+' == ch || '-' == ch) {
            return 1;
        }
        if ('/' == ch || '*' == ch) {
            return 2;
        }
        return -1;
    }

    private static int operation(int v1, int v2, char ch) {
        int result = -1;
        if ('+' == ch) {
            result = v1 + v2;
        } else if ('-' == ch) {
            result = v1 - v2;
        } else if ('*' == ch) {
            result = v1 * v2;
        } else {
            result = v1 / v2;
        }
        return result;
    }


}
