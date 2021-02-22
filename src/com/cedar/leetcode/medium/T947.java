package com.cedar.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class T947 {


    public static void main(String[] args) {


        int [] []stones=new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int ret= new T947().removeStones(stones);
        System.out.println("ret = " + ret);

    }
    public int removeStones(int[][] stones) {


        final int n=stones.length;
        UnionFind uf=new UnionFind();
        for(int[] s :stones){
            uf.union(s[0]+10000,s[1]);
        }

        return n-uf.getCount();
    }

    private class UnionFind{
        private Map<Integer,Integer> parent;
        private int count;
        public UnionFind(){
            this.parent=new HashMap<>();
            this.count=0;
        }
        private int find(int t){

            if(!parent.containsKey(t)){
                count++;
                parent.put(t,t);
            }
            int pt=parent.get(t);
            if(t!=pt){
                parent.put(t,find(pt));
                return parent.get(t);
            }
            return t;
        }
        private boolean connect(int x,int y){
            return find(x)==find(y);
        }
        public void union(int x,int y){
            if(connect(x,y))
                return;
            int hx=find(x);
            int hy=find(y);

            parent.put(hy,hx);
            count--;
        }
        public int getCount() {
            return count;
        }
    }
}
