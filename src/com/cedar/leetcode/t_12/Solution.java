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
    public String intToRoman(int num) {
        if(num<1||num>3999)return null;
        StringBuilder sb=new StringBuilder();
        //当前计数单位，默认为最大值
        int t=1000;
        //到下一个较小的计数单位，要除的值，只可能为2和5
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
                //代表在当前计数单位下
                int threshold=0;
                //500、50对应的为900、90
                if(rate==5){
                    threshold=t+t/rate*4;
                //如100、10对应的为400
                }else {
                    threshold=t*4;
                }
                //代表当前计数单位左边要加上10的幂次 所代表的符号
                if(num>=threshold){
                    //比如当前计数单位为50（L），rate为5，threshold为90
                    //先左边加上10 （X）
                    sb.append(map.get(t*10/rate-threshold));
                    //再加上100（C）
                    sb.append(map.get(t*10/rate));
                    //因此XC代表90，要从num减掉90，然后继续循环
                    num-=threshold;
                }else {
                    //代表没有超过阈值，不需要用两个符号合成
                    sb.append(map.get(t));
                    num -= t;
                }
            }
            //t变为下一个单位
            t/=rate;
            //rate在2和5之间切换
            rate=10/rate;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
