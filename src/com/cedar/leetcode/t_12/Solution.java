package com.cedar.leetcode.t_12;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxs
 * @date 2020/09/13
 * 12. 整数转罗马数字
 **/
public class Solution {
    //
    public String intToRoman(int num) {
        if(num<1||num>3999)return null;
        StringBuilder sb=new StringBuilder();
        int q=0;
        int r=0;
        int t=1000;
        int rate=2;
        Map<Integer,String>map=new  HashMap<Integer,String>;
        while (num>0){
            q=num/t;
            r=num%t;
            num-=r;
            if(q>0){
                sb.append("");
            }

            t/=rate;
            rate=10/rate;
        }
        return null;
    }


    @Test
    public void test(){
        System.out.println(intToRoman(4));
    }
}
