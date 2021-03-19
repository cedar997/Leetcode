package com.cedar.leetcode.medium;

public class T400 {
    public static void main(String[] args) {
        System.out.println(new T400().new Solution().findNthDigit(1000000000));
    }
    class Solution {
        public int findNthDigit(int n) {
            if(n<10)
                return n;

            int d=0;
            long m=0;
            for (; ; d++) {
                long m1=m+(long) Math.pow(10,d)*9*(d+1);
                if(m1>n)
                    break;
                m=m1;
            }
            long t0=n-m-1; //同级数第几位
            long d0=t0/(d+1);//第几个同级数
            int d1=(int)t0%(d+1);//第几位
            int base=(int)Math.pow(10,d);
            long r1=base+d0;
            int ret=(""+r1).charAt(d1)-'0';
            return ret  ;

        }
    }
}
