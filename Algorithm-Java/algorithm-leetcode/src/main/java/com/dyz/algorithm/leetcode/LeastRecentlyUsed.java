package com.dyz.algorithm.leetcode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LeastRecentlyUsed {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.add("ele1");
        lruCache.add("ele2");
        lruCache.add("ele3");
        System.out.println(lruCache.getSize());
        lruCache.printContent();
    }

    static class LRUCache {

        private int capacity;

        private AtomicInteger size = new AtomicInteger(0);

        // head has value, not just a pointer
        private Node head;

        LRUCache(int cap) {
            this.capacity = cap;
        }

        public void add(String value) {

        }

        private boolean full() {
            return size.get() == capacity;
        }

        private void removeLast() {
            if(Objects.isNull(head)) {
                return;
            }
            Node current = head;
            if(Objects.isNull(current.next)) {
                head = null;
            }
            while (current.next != null) {
                current = current.next;
            }
            current = null;
        }

        private void printContent() {
            if(Objects.isNull(head)) {
                return;
            }
            for (Node current = head ; head.next != null ; current = current.next) {
                System.out.print(current.value + " ");
            }
            System.out.println();
        }

        public int getSize() {
            return size.get();
        }

        static class Node {
            private String value;
            private Node next;

            Node(String value) {
                this.value = value;
            }
        }
    }
}
