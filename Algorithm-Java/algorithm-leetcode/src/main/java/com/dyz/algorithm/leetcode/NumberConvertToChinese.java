package com.dyz.algorithm.leetcode;

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
        for(int i = 0 ; i < charNumber.length ; i++) {
            int index = charNumber[i] - '0';
            if(index < 0 || index > 9) {
                return "不合法输入";
            }
            int tag = i%4;
            if(index != 0) {
                result += numbers[index] + unit[charNumber.length - i -1];
            } else {
                if(!checkZore(result)) {
                    result += numbers[index];
                } else {
                    //result += unit[charNumber.length - i -1];
                }
            }
        }
        return result;
    }

    private static boolean checkZore(String str) {
        char[] chars = str.toCharArray();
        return chars[chars.length-1] == '零';
    }
}
