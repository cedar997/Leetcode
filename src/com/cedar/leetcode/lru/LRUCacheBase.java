package com.cedar.leetcode.lru;

import java.util.HashMap;

public class LRUCacheBase {
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCacheBase(int cap) {
        this.cap = cap;
        map=new HashMap<>();
        cache=new DoubleList();

    }
    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node x=map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node x=new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }
    /* 删除某一个 key */
    private void deleteKey(int key) {
        Node x=map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    /* 删除最久未使用的元素 */
    /*
    当缓存容量已满，我们不仅仅要删除最后一个 Node 节点，
    还要把 map 中映射到该节点的 key 同时删除，
    而这个 key 只能由 Node 得到。如果 Node 结构中只存储 val，
    那么我们就无法得知 key 是什么，
    就无法删除 map 中的键，造成错误
     */
    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key,value);
            return;
        }
        if(cap== cache.size()){
            removeLeastRecently();
        }
        addRecently(key,value);
    }
}
