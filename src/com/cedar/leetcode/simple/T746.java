package com.cedar.leetcode.simple;

public class T746 {
    public static void main(String[] args) {
        int [] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = new Solution().minCostClimbingStairs(cost);

        System.out.println(i);
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=2) //两步直接跳
            return 0;
        int take=cost[1];
        int skip=cost[0];
        for(int i=2;i<cost.length;i++){
            int last_take=take;
            take=take<skip?take+cost[i]:skip+cost[i];
            skip=take<last_take?take:last_take;
        }

        return take<skip?take:skip;
    }
}
//递归解法，超时
class RecursionSolution {
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost,cost.length);
    }
    public int minCostClimbingStairs(int[] cost,int p) {

        if(p<2){ //当前仅为2阶台阶
            return 0;
        }
        else { //当前有3
            int cost1=minCostClimbingStairs(cost,p-1)+cost[p-1];
            int cost2=minCostClimbingStairs(cost,p-2)+cost[p-2];
            if(cost1>=cost2){
                return cost2;
            }
            else
                return cost1;
        }
    }

}