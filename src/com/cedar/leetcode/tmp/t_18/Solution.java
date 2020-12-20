package com.cedar.leetcode.tmp.t_18;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xxs
 * @date 2020/09/13
18. 四数之和
 *
 **/
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        int len= nums.length;
        if(nums==null||len<4)return lists;
        Arrays.sort(nums);
        for(int i=0;i<len;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            for(int j=i+1;j<len;j++) {
                //去重复
                if(j>i+1 &&nums[j]==nums[j-1]) continue;
                int L = j + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[i]+nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i],nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++; //左去重
                        while (L < R && nums[R] == nums[R - 1]) R--; //右去重
                        L++;
                        R--;
                    } else if (sum < target) L++;
                    else if (sum > target) R--;
                }
            }
        }
        return lists;
    }
    ///////////////////////////////TEST////////////////////////////


    public void test(){
        int []nums = {0,4,-5,2,-2,4,2,-1,4};

        int target=12;
        System.out.println(fourSum(nums,target));

    }
}
