package com.dyz.algorithm.leetcode;


/**
 *
 * input a number as string
 * output the chinese uppercase of the number
 *
 * example:
 * input  300767
 * output  三十万零七百六十七
 *
 *
 * 1) invalid number string
 * 2) zero value process
 *
 */
public class NumberConvertToChinese {
    public static void main(String[] args) {
        String test = "10106001";
        System.out.println(fun(test));
    }

    public static String fun(String str) {
        String result = "";
        String[] numbers = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] unit = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};
        char[] charNumber = str.toCharArray();
        if(charNumber[0] == '0' || charNumber.length > unit.length) {
            return "不合法输入";
        }

        return result;
    }
}
