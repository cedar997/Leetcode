package com.cedar.leetcode.medium;

public class T62 {
    public static void main(String[] args) {
        int m=59,n=5;
        System.out.println(new T62().new Solution().uniquePaths(m, n));
    }
    //递归方式
    class Solution1 {
        int count=1;
        public int uniquePaths(int m, int n) {
            helper(m,n);
            return count;
        }
        private boolean helper(int m,int n){
            if(m==1 || n==1){
                return true;
            }

            count++;
            helper(m-1,n);
            helper(m,n-1);
            return false;

        }
    }
    class Solution {

        public int uniquePaths(int m, int n) {

            long x=1;
            long y=1;
            int w=Math.min(m,n);

            for(int i=1;i<=w-1;i++){

                x*=(m+n-1-i);


                    y*=i;


            }

            return (int) (x/y);
        }

    }
}
