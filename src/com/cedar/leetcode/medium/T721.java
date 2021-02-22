package com.cedar.leetcode.medium;

import java.util.*;

public class T721 {
    static List<List<String>> accounts;
    public static void main(String[] args) {
        accounts=new ArrayList<>();
        put("D","0","1");
        put("D","3","4");
        put("D","4","5");
        put("D","2","3");
        put("D","1","2");
        test("1");

    }
    private static void put(String...s){
        accounts.add(Arrays.asList(s));
    }
    private static void test(String ans){

        List<List<String>> lists = new T721().new Solution().accountsMerge(accounts);
        if (lists ==null)
            return;
        for(List<String>l :lists){
            System.out.println(l);
        }
        System.out.println("ans = " + ans);
        accounts=new ArrayList<>();
    }
    class UnionFind {
        int[] parent;

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

    class Solution {
        HashMap<String,Integer> hm;
        int emailCount=0;
        HashMap<String,String> email2name =new HashMap<>();


        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            hm=new HashMap<>();

            for(List<String> acc:accounts){
                String name=acc.get(0);
                for(int i=1;i<acc.size();i++){
                    String s=acc.get(i);
                    if(!hm.containsKey(s)) {
                        hm.put(s, emailCount++);
                        email2name.put(s,name);
                    }

                }
            }
            UnionFind uf=new UnionFind(emailCount);
            for(List<String> acc:accounts) {
                String email_root = acc.get(1);
                int root=hm.get(email_root);
                ;
                //find has root

                for (int i = 2; i < acc.size(); i++) {
                    String email_cur=acc.get(i);
                    int cur=hm.get(email_cur);
                    uf.union(root,cur);
                }
            }

          //  reverse map root to list
            HashMap<Integer,List<String>> hm_reverse=new HashMap<>();
            for(Map.Entry<String,Integer> entry: hm.entrySet()){
                List<String> list=new ArrayList<>();
                int idx= uf.find(entry.getValue());
                if(hm_reverse.containsKey(idx)){
                    list=hm_reverse.get(idx);
                }
                list.add(entry.getKey());

                hm_reverse.put(idx,list);
            }

            List<List<String>> ret=new ArrayList<>();
            for(Map.Entry<Integer,List<String>> entry: hm_reverse.entrySet()){
                List<String> tail = entry.getValue();
                Collections.sort(tail);

                tail.add(0, email2name.get(entry.getValue().get(0)));
                ret.add(tail);
            }
            return ret;
        }
    }
}
