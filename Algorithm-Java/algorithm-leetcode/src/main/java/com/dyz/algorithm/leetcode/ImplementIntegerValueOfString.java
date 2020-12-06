package com.dyz.algorithm.leetcode;

import java.util.Objects;

/**
 *
 * implement the method Integer.valueOf(String s)
 * notice to handle exceptions
 *
 * -2147483648 ~ 2147483647
 */
public class ImplementIntegerValueOfString {

    public static void main(String[] args) throws Exception {
        String str = "2147483648";
        System.out.println(solution(str));
    }

    public static int solution(String str) throws Exception {
        if(Objects.isNull(str)) {
            throw new Exception("invalid input, NULL");
        }
        str = str.trim();
        if("".equals(str)) {
            throw new Exception("invalid input, empty string");
        }
        int result = 0;
        boolean negative = false;
        if(str.startsWith("-") || str.startsWith("+")) {
            if(str.startsWith("-")) {
                negative = true;
            }
            str = str.substring(1);
        }
        int limit_1 = Integer.MAX_VALUE / 10;
        int limit_2 = negative ? Math.abs(Integer.MIN_VALUE % 10) : Integer.MAX_VALUE % 10;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c < '0' || c > '9') {
                throw new Exception("invalid input " + str);
            }
            if (result > limit_1 || (result == limit_1 && (c - '0') > limit_2)) {
                throw new Exception("invalid input overflow " + str);
            }
            result = result * 10 + ((c - '0'));
        }
        return negative ? -result : result;
    }

    /*
     The output of this method is correct,
     but for Integer.MIN_VALUE -2147483648,
     the logic of this method is wrong,
     In line 72, for '-2147483648', it is not overflow, but line 72 think it is overflow.
     */
    /*
    public static int test(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0)
            return 0;
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;  //214748364
        int sign = 1;
        int i = 1;
        if(c[0] == '-')
            sign = -1;
        else if(c[0] != '+')
            i = 0;
        for(int j = i; j < c.length; j++){
            if(c[j] < '0' || c[j] > '9')
                break;
            if(res > bndry || res == bndry && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
    */
}
