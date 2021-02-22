package com.cedar.leetcode.medium;

public class T300 {
    public static void main(String[] args) {
        int []nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new T300().new Solution().lengthOfLIS(nums));
    }
        class Solution {
            public int lengthOfLIS(int[] nums) {

                int[] top = new int[nums.length];
                int ret = 0;
                for (int i = 0; i < nums.length; i++) {
                    int poker = nums[i];
                    int left = 0;
                    int right = ret;
                    //前必后开区间，退出条件left==right
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (top[mid]>poker){
                            right=mid;//mid取不到
                        }
                        else if(top[mid]<poker){
                            left=mid+1;
                        }
                        else {
                            right=mid;
                        }
                    }
                    //left为当前应插入的位置
                    if(left==ret){
                        ret++;
                    }
                    top[left]=poker;
                }
                return  ret ;
            }
        }

}
