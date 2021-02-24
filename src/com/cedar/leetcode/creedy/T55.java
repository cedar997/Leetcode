package com.cedar.leetcode.creedy;

public class T55 {
    public static void main(String[] args) {
        int nums [] ={3,2,1,0,4};
        System.out.println(new T55().new Solution().canJump(nums));
    }
    class Solution {
        public boolean canJump(int[] nums) {
            int n=nums.length;
            int farest=0;
            for (int i = 0; i < n; i++) {
                farest=Math.max(farest,i+nums[i]);
                if(farest<=i){
                    return  false;
                }
            }
            return farest>=n-1;
        }
    }
}
