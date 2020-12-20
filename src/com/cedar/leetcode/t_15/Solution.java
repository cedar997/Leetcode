package com.cedar.leetcode.t_15;



import java.util.*;

/**
 * @author xxs
 * @date 2020/09/13
 * 15、三数之和
 * @bug 无法处理多个0
 **/
public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        int len= nums.length;
        if(nums==null||len<3)return lists;
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            if(nums[i]>0)break;
            if(i>0&&nums[i]==nums[i-1])continue; //去重
            int L=i+1;
            int R=len-1;
            while(L<R){
                int sum=nums[i]+nums[L]+nums[R];
                if(sum==0){
                    lists.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] ==nums[L+1]) L++; //左去重
                    while(L<R && nums[R] ==nums[R-1]) R--; //右去重
                    L++;
                    R--;
                }
                else if(sum <0 ) L++;
                else if(sum>0)R--;
            }

        }
        return lists;
    }

    ///////////////////////////////TEST////////////////////////////


    public void test(){
        int nums[]={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists = threeSum(nums);
        if(lists!=null)
        lists.forEach(System.out::println);
    }
}
