package com.dyz.algorithm.leetcode;

import java.util.Stack;


/**
 *
 * implement a queue by using two stack
 *
 */
public class ImplementQueueByTwoStack {
    public static void main(String[] args) {
        MyStackQueue<String> queue = new MyStackQueueBetter<>();
        queue.add("ele1");
        queue.add("ele2");
        System.out.println(queue.take());
        queue.add("ele3");
        queue.add("ele4");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    static class MyStackQueue<T> {

        protected Stack<T> stack1 = new Stack<>();
        protected Stack<T> stack2 = new Stack<>();

        public void add(T ele) {
            stack1.push(ele);
        }

        public T take() {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            T last = stack2.pop();
            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return last;
        }
    }


    /*
    The optimization:  need't to swap the data between two stack when add or Take continuously.
     */
    static class MyStackQueueBetter<T> extends MyStackQueue<T> {

        @Override
        public void add(T ele) {
            if(!stack2.empty()) {
                while(!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
            }
            stack1.push(ele);
        }

        @Override
        public T take() {
            if(!stack1.empty()) {
                while(!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
