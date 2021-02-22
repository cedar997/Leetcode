package com.cedar.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

public class T354 {
    public static void main(String[] args) {

    }
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n=envelopes.length;
            Arrays.sort(envelopes,new Comparator<int[]>(){
                public int compare(int [] a,int [] b){
                    return a[0]==b[0]?
                            b[1]-a[1]:  //降序
                            a[0]-b[0];  //升序
                }
            });
            int heights []=new int [n];
            for(int i=0;i<n;i++){
                heights[i]=envelopes[i][1];
            }
            return lengthOfLIS(heights);
        }
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
                if(left==i){
                    ret++;
                }
                top[left]=poker;
            }
            return  ret ;
        }

    }


}
