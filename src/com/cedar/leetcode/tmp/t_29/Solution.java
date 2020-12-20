package com.cedar.leetcode.tmp.t_29;

public class Solution {
    public int divide(int dividend, int divisor) {
        //q为最后返回的商
        int q=0;
        int sign=1;
        if(divisor==Integer.MIN_VALUE){
            if(dividend==Integer.MIN_VALUE)
                //两最小负数相除，结果为1
                return 1;
            //除数是最小负数，则返回0
            return 0;
        }
        //除0返回最大值
        if(divisor==0)return Integer.MAX_VALUE;
        //除1返回被除数
        if(divisor==1) return dividend;
        //将除数转化为正数，并记录符号
        if(divisor<0){
            divisor=-divisor;
            sign=-sign;
        }

        if(dividend==Integer.MIN_VALUE){
            if(divisor==1)
                //结果溢出，返回指定值
                return Integer.MAX_VALUE;
            q++;
            dividend+=divisor;
        }
        //将被除数转换为正数，并调整符号
        if(dividend<0){
            dividend=-dividend;
            sign=-sign;
        }
        //用减法模拟除法
        while(dividend>=divisor){
            dividend-=divisor;
            q++;
        }
        //结果加上符号
        if(sign<0) return -q;
        return q;
    }
}
