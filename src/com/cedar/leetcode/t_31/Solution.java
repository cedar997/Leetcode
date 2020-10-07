package com.cedar.leetcode.t_31;
import com.cedar.utils.ListNode;

import java.util.Arrays;

class Solution {
    //////////////////////
    public static void nextPermutation(int[] nums) {
        int len=nums.length;
        if(len==1) return;
        if(len==2){
            swap(nums,0,1);
            return;
        }
        int q=len-1;
        int p=len-2;
        int k=len-3;
        while(k>=0){
            if(nums[q]>nums[p]){// pq顺序
                swap(nums,p,q);
                return;
            }
            else { //pq逆序
                if(nums[k]<nums[q]){ //k 最小
                    swap(nums,p,q);
                    swap(nums,k,p);
                    return;
                }
                if(nums[k]>=nums[p]){ //k最大
                    while(k>0&&nums[k-1]>=nums[k])k--;
                    if(k>0)k--;
                    else {
                        Arrays.sort(nums);
                        return;
                    }
                    p=q;
                    while (p>k&&nums[p]<=nums[k])p--;
                    System.out.println("k = " + k);
                    System.out.println("p = " + p);
                    swap(nums,k,p);
                    break;
                }
                else { //k居中
                    swap(nums,k,p);
                    swap(nums,p,q);
                    return;
                }
            }
        }
        Arrays.sort(nums,k+1,len);
    }
    private static void swap(int[] nums,int p,int q){
        int temp=nums[q];
        nums[q]=nums[p];
        nums[p]=temp;
    }
    /////////////////////////
    public static void main(String[] args) {
        int[] nums={2,1,2,2,2,2,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
