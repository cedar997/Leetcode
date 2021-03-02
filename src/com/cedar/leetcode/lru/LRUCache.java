package com.cedar.leetcode.lru;

import java.util.LinkedHashMap;

public class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();

    public LRUCache(int cap) {
        this.cap = cap;
    }
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
        return val;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
            return;
        }
        if(cache.size()>=cap){
            // 链表头部就是最久未使用的 key
            Integer first = cache.keySet().iterator().next();
            cache.remove(first);
        }
        cache.put(key,value);
    }
}
