package com.cedar.leetcode.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

//LeetCode-460
class LFUCache {

    // key 到 val 的映射
    HashMap<Integer,Integer> keyToVal;
    // key 到 freq 的映射
    HashMap<Integer,Integer> keyToFreq;
    // freq 到 key 列表的映射，
    /*
    LinkedHashSet，它满足我们 3.3，3.4，3.5 这几个要求
3.3、可能有多个key拥有相同的freq，所以 freq对key是一对多的关系，即一个freq对应一个key的列表。
3.4、希望freq对应的key的列表是存在时序的，便于快速查找并删除最旧的key。
3.5、希望能够快速删除key列表中的任何一个key，因为如果频次为freq的某个key被访问，那么它的频次就会变成freq+1，
就应该从freq对应的key列表中删除，加到freq+1对应的key的列表中。
     */
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    int cap;
    public LFUCache(int capacity) {
        this.cap =capacity;
        keyToVal=new HashMap<>();
        keyToFreq=new HashMap<>();
        freqToKeys=new HashMap<>();
        this.minFreq=0;
    }

    public int get(int key) {
        if(cap==0)
            return -1;
        if(!keyToVal.containsKey(key))
            return -1;
        increseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(cap==0)
            return ;
        if(keyToVal.containsKey(key)){
            //keyToVal.remove(key);
            keyToVal.put(key,value);
            increseFreq(key);
            return;
        }
        //key不存在
        if(keyToVal.size()>=cap){
            removeMinFreqKey();
        }
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq=1;
    }
    public void increseFreq(int key){
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);

        freqToKeys.get(freq).remove(key);

        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        //// 如果 freq 对应的列表空了，移除这个 freq
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if(freq==minFreq){
                minFreq++;
            }
        }
    }
    public void removeMinFreqKey(){
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        Integer keyToDelete = keyList.iterator().next();
        keyList.remove(keyToDelete);
        if(keyList.isEmpty()){
            freqToKeys.remove(minFreq);
            //没必要更新minFreq变量
        }
        keyToVal.remove(keyToDelete);
        keyToFreq.remove(keyToDelete);
    }
}