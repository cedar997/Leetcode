package com.cedar.leetcode.hard;

import java.util.HashMap;

public class T887 {
    public static void main(String[] args) {
        System.out.println(new T887().new Solution().superEggDrop(3, 14));
    }
    class Solution {
        HashMap<Integer,Integer> memo=new HashMap<>();
        public int superEggDrop(int K, int N) {


            return dp(K, N);
        }
        int dp(int K,int N){
            if(K==1){ //只有一个鸡蛋，就从下到上依次尝试
                return N;
            }
            if(N==0)
                return 0;
            if(memo.containsKey(N*100+K))
                return memo.get(N*100+K);
            int ret=0;
            int lo=1;
            int hi=N;
            //退出条件：lo+1 == hi
            while (lo+1<hi){
                int mid=lo+(hi-lo)/2;
                int t1=dp(K-1,mid-1); //如果蛋碎了
                int t2=dp(K,N-mid);     //如果蛋没碎
                if(t1<t2){
                    lo=mid;
                }
                else if(t1>t2){
                    hi=mid;
                }
                else { //t1==t2 蛋碎不碎的代价相等
                    lo=hi=mid;
                }
            }
            int v_lo=Math.max(dp(K - 1, lo - 1), dp(K, N - lo));
            int v_hi=Math.max(dp(K - 1, hi - 1), dp(K, N - hi));
            ret=1 + Math.min(v_lo, v_hi);
            memo.put(N*100+K,ret);
            return ret;
        }
    }
}
