package com.cedar.leetcode.creedy;

public class T45 {
    public static void main(String[] args) {
        int nums [] ={3,2,1,0,4};
        System.out.println(new T45().new Solution().jump(nums));
    }
    class Solution {
        public int jump(int[] nums) {
            int n=nums.length;
            int farest=0;
            int jump=0;
            int end=0;
            for(int i=0;i<n-1 ;i++){

                farest=Math.max(farest,i+nums[i]);
                if(i==end){
                    jump++;
                    end=farest;
                }



            }
            return jump;
        }
    }
}
