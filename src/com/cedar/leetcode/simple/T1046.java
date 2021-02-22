package com.cedar.leetcode.simple;

import java.util.Arrays;

public class T1046 {
    public static void main(String[] args) {
        int [] stones={2,7,4,1,8,1};
        System.out.println(new T1046().lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n==0)
            return 0;
        if(n==1)
            return stones[0];

        while (n>1){
            Arrays.sort(stones);
            stones[n-2]=stones[n-1]-stones[n-2];
            stones[n-1]=20000;
            n--;
        }
        return stones[0];



    }
}
