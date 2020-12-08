package com.dyz.algorithm.leetcode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * implement a LRU algorithm by use a own defined linkedList
 *
 * get: remove this element, then put this ele at the first.
 * put: put at the first
 * full: remove the last element
 *
 *
 */
public class LRUByOwnDefinedLinkedList {

    public static void main(String[] args) {
        LRUCache<String> lruCache = new LRUCache<>(5);
        lruCache.put("ele1");
        lruCache.put("ele2");
        lruCache.put("ele3");
        lruCache.put("ele4");
        lruCache.put("ele5");
        lruCache.print(); // [ele5,ele4,ele3,ele2,ele1]

        // remove the last element if more than capacity
        lruCache.put("ele6");
        lruCache.print(); // [ele6,ele5,ele4,ele3,ele2]

        // put the element at the first where access this element
        String ele = lruCache.get("ele4");
        lruCache.print(); // [ele4,ele6,ele5,ele3,ele2]
    }

    static class LRUCache<T> {
        private CacheNode<T> head;
        private int capacity;
        private AtomicInteger size = new AtomicInteger(0);
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new CacheNode<>(null);
        }

        public T get(T value) {
            this.remove(value);
            this.addAtFirst(value);
            return value;
        }

        public void put(T value) {
            if(this.capacity == this.size.get()) {
                this.removeAtLast();
            }
            if(this.exist(value)) {
                this.remove(value);
            }
            this.addAtFirst(value);
        }

        private void remove(T value) {
            CacheNode<T> current = this.head;
            while (Objects.nonNull(current.next)) {
                if(current.next.value.equals(value)) {
                    CacheNode<T> temp = current.next.next;
                    current.next.next = null;
                    current.next = temp;
                    this.size.decrementAndGet();
                }
                current = current.next;
            }
        }

        private void addAtFirst(T value) {
            CacheNode<T> newNode = new CacheNode<>(value);
            CacheNode<T> temp = this.head.next;
            this.head.next = newNode;
            newNode.next = temp;
            this.size.incrementAndGet();
        }

        private void removeAtLast() {
            CacheNode<T> current = this.head;
            while(Objects.nonNull(current.next)) {
                if(Objects.isNull(current.next.next)) {
                    current.next=null;
                    this.size.decrementAndGet();
                    return;
                }
                current = current.next;
            }
        }

        private boolean exist(T value) {
            CacheNode<T> current = this.head;
            while (Objects.nonNull(current.next)) {
                if(current.next.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            CacheNode<T> current = this.head;
            sb.append("[");
            while (Objects.nonNull(current.next)) {
                sb.append(current.next.value);
                if(Objects.nonNull(current.next.next)) {
                    sb.append(",");
                }
                current = current.next;
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    static class CacheNode<T> {
        private T value;
        private CacheNode<T> next;
        public CacheNode(T value) {
            this.value = value;
        }
    }
}
