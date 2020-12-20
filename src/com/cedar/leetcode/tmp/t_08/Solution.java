package com.cedar.leetcode.tmp.t_08;



/**
 * @author xxs
 * @date 2020/09/12
 **/
public class Solution {
    public int myAtoi(String str) {
        int len=str.length();
        char[] charArray=str.toCharArray();
        int i=0;
        while ( i<len && charArray[i]==' ' )i++;
        if(i==len)return 0;
        int sign=1;
        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        else if(str.charAt(i)=='+'){
            i++;
        }
        int ret=0;
        for(;i<len;i++){
            char c=charArray[i];
            //非数字
            if(c>'9'||c<'0') {
                break;
            }
            int a=c-'0';
            //提前判断溢出
            if(ret>Integer.MAX_VALUE/10||(ret==Integer.MAX_VALUE/10&&a>Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if(ret<Integer.MIN_VALUE/10||(ret==Integer.MIN_VALUE/10&&a>Integer.MAX_VALUE%10)){
                return Integer.MIN_VALUE;
            }

            ret=ret*10+sign*a;
        }
        return ret;
    }

    public void test(){
        String s=" ";
        int i=myAtoi(s);
        System.out.println(i);
    }
}
