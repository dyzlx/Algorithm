package com.dyz.algorithm.leetcode;

/**
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Example 4:
 * Input: x = 0
 * Output: 0
 *
 * -2147483648 ~ 2147483647
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int input = 21474;
        System.out.println(solution_1(input));
        System.out.println(solution_2(input));
    }

    /*
    convert int to string, then reverse string, then convert to int
    catch exception and return 0 if overflow when convert reversed string to int.
     */
    public static int solution_1(int number) {
        String numberStr = String.valueOf(number);
        int flag = 1;
        if(number < 0) {
            flag = -1;
            numberStr = numberStr.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuilder(numberStr).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     The following points are very important
     1) notice negative number.
     2) number may overflow after reverse.
     */
    public static int solution_2(int number) {
        // do not get the absolute value of the number
        // if the number is Integer.MIN_VALUE, get abs will overflow immediately
        // int copy = Math.abs(number);
        long result = 0;  // how can I have the courage to use long type!
        while (number != 0) {
            int remainder = number % 10;
            result = result * 10 + remainder;
            number = number / 10;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int)result;
        // another way
        // return (int)result == result ? (int)result : 0;
    }

}
