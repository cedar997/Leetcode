package com.cedar.leetcode.arrays;

import java.util.Arrays;

public class T136 {
    public static void main(String[] args) {
        int[] nums={2,1,2};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber_normal(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        Arrays.sort(nums);
        int i=1;
        while ( i<n) {
            if(nums[i]==nums[i-1]){
                i+=2;
            }else {
                return nums[i-1];
            }
        }
        return nums[i-1];
    }
    //异或运算
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
