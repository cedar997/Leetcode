package com.cedar.leetcode.t_18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; //左去重
                    while (L < R && nums[R] == nums[R - 1]) R--; //右去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return lists;
    }
    ///////////////////////////////TEST////////////////////////////


    @Test
    public void test(){
        int []nums = {1, 0, -1, 0, -2, 2};
        int target=0;
        System.out.println(fourSum(nums,target));

    }
}
