package com.cedar.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T1319 {
    public static void main(String[] args) {
        int [][] connections={{0,1},{0,2},{0,3},{1,2}};
        System.out.println(new T1319().makeConnected(6, connections));
    }
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf=new UnionFind(n);
        for(int[] con:connections){
            uf.union(con[0],con[1]);
        }
        uf.printParent();

        return 0;
    }
    class UnionFind {
        int[] parent;

        public void printParent(){
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<parent.length;i++){
                if(hm.containsKey(parent[i])){
                    hm.put(parent[i],1);
                }
                else {
                    Integer old = hm.get(parent[i]);
                    hm.put(parent[i],old+1);
                }
            }
            int ret=0;
            for(Integer k:hm.keySet()){
                int temp=hm.get(k);
            }
        }
        public UnionFind(int n) {

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {

            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
