package com.cedar.leetcode.t_10;

import org.junit.Test;

/**
 * @author xxs
 * @date 2020/09/12
 **/
public class Solution {
    @Test
    public void test(){
        String s="ajbkb";
        String p="a*b";
        System.out.println(isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        char[] p_char=p.toCharArray();
        char[] s_char=s.toCharArray();
        int j=0;
        int k=0;
        for(int i=0;i<p.length();i++){
            if(j>=s.length()){
                return false;
            }
            if(p_char[i]=='.'){
                j++;
            }else if(p_char[i]=='*'){

                k=i+1;
                if(k>=p_char.length){  //以*结尾
                    return true;
                }
                if(p_char[k]!=s_char[j]){
                    j++;
                    i--;
                }else {
                    j++;
                    i++;

                }
            }else {
                if(p_char[i]!=s_char[j]){
                    return false;
                }

                j++;
            }

        }
        if (j<s.length()){
            return false;
        }
        return true;
    }
}
