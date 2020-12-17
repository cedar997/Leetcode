package com.cedar.leetcode.t_33;

class Solution {
    public static int search(int[] nums, int target) {
        int len=nums.length;
        int s4= search_s4(nums);
        return search(nums,s4,target);
    }
    //寻找拐点s4
    private static int search_s4(int[] nums){
        int left=0;
        int right=nums.length-1;
        //如果只有一个元素，则返回
        if(left==right) return left;
        int mid=-1;
        //用二分查找找到拐点
        while(left<=right){
            mid=(left+right)/2;
            if(mid==right) break;
            //找到拐点
            if(nums[mid]>nums[mid+1])
                return mid;
            //拐点在右边
            else if(nums[mid]>=nums[left])
                left=mid+1;
            //拐点在左边
            else
                right=mid-1;
        }
        return mid;

    }
    //在获得s4后，进行最终的查找
    private static int search(int [] nums,int s4,int target){
        int s3=0;
        int s2= nums.length-1;
        //最小值s1,就在s4的下一个位置
        int s1=s4+1;
        //如果s4位于末尾，s1则回到开始
        if(s1>=nums.length)s1=s3;
        //要查找的数比最大值大，或比最小值小，就返回-1
        if(target>nums[s4] || target<nums[s1]) return -1;
        int left=s1,right=s4;
        //判断目标数==s3
        if(target==nums[s3]) return s3;
        //目标数大于s3，则在s3到s4之间查找
        else if(target>nums[s3])
            left=s3;
        //目标数小于s3，则在s1到s2之间查找
        else
            right=s2;
        //在指定区域使用二分查找
        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid])return mid;
            else if(target<nums[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={1,3};

        int i = search(nums, 0);
        System.out.println("i = " + i);
    }
    ////////////////官方答案
    public int _search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}