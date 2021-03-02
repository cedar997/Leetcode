package com.cedar.leetcode.uf;

import com.cedar.utils.UnionFind;

public class T990 {
    public static void main(String[] args) {
        String [] equtions={"a==b","b==c","a!=c"};
        boolean b = new T990().new Solution().equationsPossible(equtions);
        System.out.println(b);
    }
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind uf=new UnionFind(26);
            int n=equations.length;
            for (int i = 0; i < n; i++) {
                if(equations[i].charAt(1)=='='){
                    int c1 = equations[i].charAt(0)-'a';
                    int c2 = equations[i].charAt(3)-'a';
                    uf.union(c1,c2);
                }
            }
            for (int i = 0; i < n; i++) {
                if(equations[i].charAt(1)=='!'){
                    int c1 = equations[i].charAt(0)-'a';
                    int c2 = equations[i].charAt(3)-'a';
                    if(uf.connected(c1,c2)){
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
