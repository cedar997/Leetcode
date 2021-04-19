package com.cedar.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    public static void main(String[] args) {
        int[] nums={1,2,3};

        System.out.println(new T78().new Solution().subsets(nums));
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n=nums.length;
            int m=1<<n;
            List ret=new ArrayList();
            for (int i = 0; i < m; i++) {
                List cur=new ArrayList();
                for (int j = 0; j < n; j++) {
                    if(((1<<j) & i)>0){
                        cur.add(nums[j]);
                    }
                }
                ret.add(cur);
            }
            return ret;
        }
    }
}
