package com.dyz.algorithm.leetcode;


import java.util.Objects;

/**
 *
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 *
 *
 */

/**
 *
 * 1) refer to char sort:
 *     int[] frequency = new int[26];   frequency[char-'a']
 *     or
 *     int[] frequency = new int[256];    frequency[char]
 * 2) 'a' - 'z' is naturally ordered
 *
 */

public class IncreasingDecreasingString {

    public static void main(String[] args) {
        String input = "aaaabbbbccccdddxx";
        System.out.println(solution(input));
    }

    /*
    there are three points to enhance:
    1) the length for int array to store element frequency can be reduce to 26
    2) the condition that return from loop can be more simple
    3) the condition that element exist in array can be more simple
     */
    public static String solution(String param) {
        StringBuilder result = new StringBuilder();
        if(Objects.isNull(param) || "".equals(param)) {
            return param;
        }
        if(param.length() < 1 || param.length() > 500) {
            return "too long input";
        }
        String input = param.toLowerCase();
        char[] inputChars = input.toCharArray();

        // get frequency for each char
        // 1)
        // int[] frequency = new int[256];
        // for(char c : inputChars) {
        //     frequency[c]++;
        // }
        // enhance for 1)
        int[] frequency = new int[26];
        for(char c : inputChars) {
            frequency[c-'a']++;
        }

        // loop until frequency = 0 for each element
        // 2)
        // while (!overTag(frequency)) {
        // enhance for 2)
        boolean flag = true;
        while (flag) {
            // enhance for 2)
            flag = false;
            // loop from a -> z
            for(char i = 'a' ; i <= 'z' ; i++) {
                // 3)
                // if(exist(inputChars, i, frequency)) {
                // enhance for 3)
                if(frequency[i-'a'] > 0) {
                    // frequency[i]--;
                    // enhance for 1)
                    frequency[i-'a']--;
                    result.append(i);
                    // enhance for 2)
                    flag = true;
                }
            }
            // loop from z -> a
            for(char i = 'z' ; i >= 'a' ; i--) {
                // 3)
                // if(exist(inputChars, i, frequency)) {
                // enhance for 3)
                if(frequency[i-'a'] > 0) {
                    // frequency[i]--;
                    // enhance for 1)
                    frequency[i-'a']--;
                    result.append(i);
                    // enhance for 2)
                    flag = true;
                }
            }
        }
        return result.toString();
    }
    /*
    private static boolean exist(char[] source, char target, int[] frequency) {
        for(char c : source) {
            // important : frequency is not 0
            if(target == c && frequency[target] != 0) {
                return true;
            }
        }
        return false;
    }
    private static boolean overTag(int[] frequency) {
        for(int i : frequency) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }*/
}





































