package com.cedar.leetcode.t_13;



import java.util.HashMap;
import java.util.Map;

/**
 * @author xxs
 * @date 2020/09/13
 * 12. 整数转罗马数字
 **/
public class Solution {
    //
    public int romanToInt(String s) {
        char[] charArray=s.toCharArray();
        int sum=0;
        Map<Character,Integer>map=new  HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        for (int i = 0; i < s.length(); i++) {

            if((i!=charArray.length-1)&&(map.get(charArray[i])<map.get(charArray[i+1]))){
                sum+=map.get(charArray[i+1])- map.get(charArray[i]);
                i++;
            }else {
                sum += map.get(charArray[i]);
            }
        }
        return sum;
    }




    public void test(){

        System.out.println(romanToInt("MCMXCIV"));
    }
}
