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
        Map<Integer,String>map=new  HashMap<Integer,String>();
        map.put(1000,"M");
        map.put(500,"D");
        map.put(100,"C");
        map.put(50,"L");
        map.put(10,"X");
        map.put(5,"V");
        map.put(1,"I");

        while (t!=0){
            while(num>=t){
                int threshold=0;
                if(rate==5){
                    threshold=t+t/rate*4;
                }else {
                    threshold=t*4;
                }
                if(num>=threshold){  //是否4 9

                    sb.append(map.get(t*10/rate-threshold));
                    sb.append(map.get(t*10/rate));
                    num-=threshold;
                }else {
                    sb.append(map.get(t));
                    num -= t;
                }
            }
            t/=rate;
            rate=10/rate;
        }
        return sb.toString();
    }


    @Test
    public void test(){

        System.out.println(intToRoman(3));
    }
}
