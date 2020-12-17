package com.cedar.leetcode.t_43;

import java.util.Arrays;

/**
 * @Author xxs
 * @Date 2020/10/10 下午2:38
 */
public  class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")|| num2.equals("0"))
            return "0";  //其中一个因数为0，乘积为0
        int len1=num1.length();
        int len2=num2.length();
        int len=len1+len2; //乘积的最大可能长度
        int[] result=new int[len]; //保存乘积中间结果的数组
        for (int i = 0; i < len; i++) {
            result[i]=-1;//-1代表没有被涉及到
        }
        for (int i = 0; i <len1; i++) {
            for (int j = 0; j<len2; j++) {
                //第i位和第j位相乘的结果不考虑进位，应该在第i+j位
                if(result[i+j]==-1)result[i+j]=0;
                result[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=len-1; i >=0 ;i--) {
            if(result[i]==-1)continue;
            if(i>0){
                //如果某位比10大，则需要进位
                result[i-1]+=result[i]/10;//进位值
                result[i]=result[i]%10; //该位剩余值
            }
            //采用头插法建立结果字符串
            sb.insert(0,result[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String num1="600";
        String num2="500";
        String result=new Solution().multiply(num1,num2);
        System.out.println("result = " + result);
    }
}
