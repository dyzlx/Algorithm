package com.dyz.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * 字符串input中统计单词（字符串）target的出现次数；
 * 注意：单词通过非英文字符分割
 *
 */
public class Test {


    public static void main(String[] args) {

    }


    public static Integer count(String input, String target) {
        if(StringUtils.isBlank(input) || StringUtils.isBlank(target)) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        String[] strArray = input.split(" ");
        for(String word : strArray) {
            Integer count = map.get(word);
            if(Objects.isNull(count)) {
                map.put(word, 1);
            } else {
                map.put(word, count+1);
            }
        }
        return map.get(target);
    }

    public static Integer count1(String input, String target) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for(int i = 0, j = 0 ; i < chars.length ; i++) {
            if(!(('a' < chars[i] && chars[i] < 'z') || ('A' < chars[i] && chars[i] < 'Z'))) {
                String ele = input.substring(j, i-1);
                Integer count = map.get(ele);
                if(Objects.isNull(count)) {
                    map.put(ele, 1);
                } else {
                    map.put(ele, count+1);
                }
                j = i ;
            }
        }
        return map.get(target);
    }
}
