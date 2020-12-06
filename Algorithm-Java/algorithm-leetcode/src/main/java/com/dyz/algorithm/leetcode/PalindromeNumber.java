package com.dyz.algorithm.leetcode;


/**
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Follow up: Could you solve it without converting the integer to a string?
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int input = 2132112312;
        System.out.println(solution_1(input));
        System.out.println(solution_2(input));
    }

    /*
    convert this integer to string
     */
    public static boolean solution_1(int number) {
        if(number < 0 || number % 10 == 0) {
            return false;
        }
        String numberStr = String.valueOf(number);
        char[] numberChars = numberStr.toCharArray();
        int length = numberChars.length;
        int i = 0;
        int j = length - 1;
        while(i < j) {
            if(numberChars[i] != numberChars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*
    concatenate a new numbers from left to right by taking the remainder and the quotient

     */
    public static boolean solution_2(int number) {
        if(number < 0 || number % 10 == 0) {
            return false;
        }
        int input = number;
        int other = 0;
        while (other < input) {
            int i = input % 10;
            other = other * 10 + i;
            input = input / 10;
        }
        return input == other || other / 10 == input;
    }
}
