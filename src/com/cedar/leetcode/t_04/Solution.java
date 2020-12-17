package com.cedar.leetcode.t_04;

class Solution {
   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m=nums1.length;
       int n=nums2.length;
       if(m==0 && n== 0) return 0.0;
       //当总数为奇数时mid1=mid2,偶数时mid1+1=mid2
        //左中间位置
       int mid1=(m+n+1)/2;
        //右中间位置
       int mid2=(m+n+2)/2;
        //左中间数
       int one=0;
        //右中间数
       int two=0;
        //当第一个数组为空时
       if(m==0){
           one=nums2[mid1-1];
           two=nums2[mid2-1];
       }
       //当第二个数组为空时
       else if(n==0){
           one=nums1[mid1-1];
           two=nums1[mid2-1];
       }
       //当两个数组都不为空
       else{
        //i遍历第一个数组，j遍历第二个数组，k遍历合成的数组
        //k遍历到右中间位置为止
           for(int k=1,i=0,j=0;k<=mid2;k++){
        //第一个数组遍历完
               if(i==m)
                   two=nums2[j++];
         //第二个数组遍历完  
               else if(j==n)
                   two=nums1[i++];
        //将两个数组中较小的数，记录为右中间数
               else if(nums1[i]<=nums2[j])
                   two=nums1[i++];
               else
                   two=nums2[j++];
        //如果到达左中间位置，记录左中间数
               if(k==mid1) one=two;
           }
       }
       //最后的中间值为左中间数和右中间数的平均数
       return (one+two)/2.0;
   }
   public static void main(String[] args) {
       int [] nums1={1,2,3,4};
       int [] nums2={8,9};
       double d=new Solution().findMedianSortedArrays(nums1,nums2);
       System.out.println(d);
   }
}