package com.cedar.leetcode.t_14;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxs
 * @date 2020/09/13
 * 14、最长公共前缀
 **/
public class Solution {
    //
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        if(strs.length==0)return "";
        int min=strs[0].length();
        for (int i = 1; i < strs.length; i++) {

            if(strs[i].length()<min)min =strs[i].length();
        }
        if(min==0)return "";

        for(int i=0;i<min;i++){
            char c=strs[0].charAt(i);
            int j=1;
            for(;j< strs.length;j++){
                if(c!=strs[j].charAt(i)){
                    break;
                }
            }
            if(j< strs.length){
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }


    @Test
    public void test(){
        String [] strs=new String[]{"zlower","dlow","floght"};
        System.out.println(longestCommonPrefix(strs));
    }
}
