package com.cedar.leetcode.t_16;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author xxs
 * @date 2020/09/13
 * 16. 最接近的三数之和
 *
 **/
public class Solution {


    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)return 0;
        Arrays.sort(nums);
        int len= nums.length;
        int close= nums[0]+ nums[1]+nums[2];
        for(int i=0;i<len;i++){
            int L=i+1;
            int R=len-1;
            while (L<R) {
                int temp = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - temp) < Math.abs(target - close)) {
                    close = temp;
                }
                if (temp > target) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return close;
    }

    ///////////////////////////////TEST////////////////////////////



    public void test(){
        int [] nums={0,2,1,-3};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
