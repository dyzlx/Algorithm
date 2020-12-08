package com.dyz.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Implement a LRU algorithm by <java>LinkedHashMap<java/>
 *
 */
public class LRUByLinkedHashMap {

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(5);
        lruCache.put("k1", "V1");
        lruCache.put("k2", "V2");
        lruCache.put("k3", "V3");
        lruCache.put("k4", "V4");
        lruCache.put("k5", "V5");
        lruCache.print();

        lruCache.get("k4");
        lruCache.get("k2");
        lruCache.print();

        lruCache.put("k6", "V6");
        lruCache.print();
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        // third param must set true
        public LRUCache(int capacity) {
            super(4, 0.75f, true);
            this.capacity = capacity;
        }

        // override this method, the condition of remove last element
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return capacity < this.size();
        }

        public void print() {
            System.out.println(super.toString());
        }
    }
}
