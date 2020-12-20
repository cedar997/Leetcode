package com.cedar.leetcode.t_15;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xxs
 * @date 2020/09/13
 * 15、三数之和
 * @bug 无法处理多个0
 **/
public class SolutionWithBug {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums.length<3)return lists;
        //排序
        nums=sort(nums);
        //寻找非负位置
        int rightLim=1;
        for(;rightLim< nums.length;rightLim++){
            if(nums[rightLim-1]* nums[rightLim]<=0)break;
        }
        if(rightLim== nums.length){
            return lists;
        }


        int ti=-1;
        for(int i=0;i<rightLim;i++){
            if(ti==-1){
                ti=i;
            }else if(nums[ti]==nums[i]){  //遇到重复值跳过
                continue;
            }

            int tj=-1;
            for(int j= nums.length-1;j>i;j--) {
                if(tj==-1){
                    tj=j;
                }else if(nums[tj]==nums[j]){
                    continue;
                }

                int val = nums[i] + nums[j];
                int mid = binarySearch(nums, i+1, j, -val);
                if (mid != -1 ) {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[mid]);
                    list.add(nums[j]);
                    lists.add(list);
                    ti=i;
                    tj=j;
                }

            }
        }
        return lists;
    }
    public int[] sort(int [] nums){
        for(int i=0;i< nums.length-1;i++){
            for(int j=i;j< nums.length;j++){
                if(nums[i]> nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return  nums;
    }
    public int binarySearch(int [] nums,int left,int right,int val){
        while (left<right) {
            int mid = (left + right) / 2;
            if (nums[mid] == val) return mid;
            else if (nums[mid] > val) {
                right = mid;
            } else {
                left = mid+1;
            }

        }
        return -1;
    }
    ///////////////////////////////TEST////////////////////////////

    public void testSort(){
        int nums[]={-1,0,1,2,-1,-4};
        int[] sort = sort(nums);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    public void testBinarySearch(){
        int nums[]={-2,0,1,1,2};
        int i = binarySearch(nums, 0, 2, 1);
        System.out.println(i);
    }

    public void test(){
        int nums[]={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists = threeSum(nums);
        if(lists!=null)
        lists.forEach(System.out::println);
    }
}
