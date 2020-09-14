package com.cedar.leetcode.t_11;

import org.junit.Test;

/**
 * @author xxs
 * @date 2020/09/13
 **/
public class Solution2 {
    // 双指针法
    public int maxArea(int[] height) {
        int max=0;
        if(height.length==0)return 0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            int vol=j-i;
            if(height[i]>height[j]){
                vol*=height[j];
                j--;
            }else {
                vol*=height[i];
                i++;
            }
            max=vol>max?vol:max;
        }
        return max;
    }

    @Test
    public void test(){
        int [] list={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(list));
    }
}
