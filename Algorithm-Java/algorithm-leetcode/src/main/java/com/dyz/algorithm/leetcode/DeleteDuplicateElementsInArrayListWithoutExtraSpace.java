package com.dyz.algorithm.leetcode;

public class DeleteDuplicateElementsInArrayListWithoutExtraSpace {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,2,3,3,3,4,5,6,6,7,7,7};
        int result = fun(array);
        System.out.println(result);
        for(int i=0;i<result;i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static int fun(int[] input) {
        int length = input.length;
        if(0 == length) return 0;
        int index = 0;
        for(int i = 0 ; i < length-1 ; i++) {
            if(input[index] != input[i+1]) {
                index++;
                input[index] = input[i+1];
            }
        }
        return index+1;
    }
}
