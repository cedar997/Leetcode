package com.cedar.leetcode.t_11;


/**
 * @author xxs
 * @date 2020/09/13
 **/
public class Solution {
    // 暴力解法
    public int maxArea(int[] height) {
        int max=0;
        int n=height.length;
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int s= height[i]<height[j]?height[i]:height[j];
                int vol=(j-i)*s;
                max=vol>max?vol:max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] list={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(list));
    }

}
