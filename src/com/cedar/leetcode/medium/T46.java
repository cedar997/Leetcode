package com.cedar.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class T46 {
    public static void main(String[] args) {
        int [] input=new int[]{1,2,3};
        System.out.println(new T46().new Solution().permute(input));
    }
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();



            int n = nums.length;

            backtrack(n, nums, res, 0);
            return res;
        }

        public void backtrack(int n, int[] output, List<List<Integer>> res, int first) {
//            // 所有数都填完了
//            if (first == n) {
//                res.add(output.);
//            }
//            for (int i = first; i < n; i++) {
//                // 动态维护数组
//                Collections.swap(output, first, i);
//                // 继续递归填下一个数
//                backtrack(n, output, res, first + 1);
//                // 撤销操作
//                Collections.swap(output, first, i);
//            }
        }
    }


}
