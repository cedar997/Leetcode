package com.cedar.leetcode.t_31;

import com.cedar.utils.ListNode;

import java.util.Arrays;

class Solution {
    //////////////////////
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) return;
        //当只有两个数时，互换位置即可
        if (len == 2) {
            swap(nums, 0, 1);
            return;
        }
        //最后三个数的索引
        int q = len - 1;
        int p = len - 2;
        int k = len - 3;
        //最后两个数递增，则交换这两个数即可
        if (nums[q] > nums[p]) {
            swap(nums, p, q);
            return;
        }
        //最后两个数不递增，需要考虑前面的数
        else {
            //k 最小，如132
            if (nums[k] < nums[q]) {
                //交换末尾两数，如123
                swap(nums, p, q);
                //再交换前两个数，如213
                swap(nums, k, p);
                return;
            }
            //倒数第三个数k最大，如15432
            if (nums[k] >= nums[p]) {
                while (k > 0 && nums[k - 1] >= nums[k]) k--;
                //从右往左，找到第一个减小的数，如找到了1
                if (k > 0) k--;
                else {
                    //如果整个序列为降序如65432，则排成升序23456
                    Arrays.sort(nums);
                    return;
                }
                p = q;
                //找到大于k对应的数，如2
                while (p > k && nums[p] <= nums[k]) p--;
                //交换k和p位置上的数，如25431
                swap(nums, k, p);
                //由于k后面为降序，因此将后面进行升序排序即可，如21345
                Arrays.sort(nums, k + 1, len);
                return;
            }
            //k居中，如342
            else {
                //交换前两个数，如432
                swap(nums, k, p);
                //再交换后两个数，如423
                swap(nums, p, q);
                return;
            }
        }
    }

    //交换数组中索引为p,q两个元素的值
    private static void swap(int[] nums, int p, int q) {
        int temp = nums[q];
        nums[q] = nums[p];
        nums[p] = temp;
    }

    /////////////////////////
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 2, 2, 2, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
