package com.cedar.leetcode.t_09;


/**
 * @author xxs
 * @date 2020/09/12
 **/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x==0) return true;
        if(x%10==0)return false;
        String s=String.valueOf(x);
        int len=s.length();
        char[] charArray=s.toCharArray();
        for(int i=0;i<len/2;i++){
            if(charArray[i]!=charArray[len-i-1]){
                return false;
            }
        }
        return true;
    }

    public void test(){
        int i=0;
        boolean b=isPalindrome(i);
        System.out.println(b);
    }
}
