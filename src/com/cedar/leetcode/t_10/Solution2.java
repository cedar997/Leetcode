package com.cedar.leetcode.t_10;

import org.junit.Test;

/**
 * @author xxs
 * @date 2020/09/13
 **/
public class Solution2 {
    @Test
    public void test(){
        String s="aaab";
        String p="a*b";
        System.out.println(isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        int s_len=s.length();
        int p_len=p.length();
        boolean[][] f=new boolean[s_len+1][p_len+1];
        f[0][0]=true;

        for(int i=0;i<=s_len;i++){
            for(int j=1;j<=p_len;j++){
                if(p.charAt(j-1)=='*'){
                    f[i][j] =f[i][j-2];
                    if(match(s,p,i,j-1)){
                        f[i][j] =f[i][j] ||f[i-1][j];
                    }
                }
                else{
                    if(match(s,p,i,j)){
                        f[i][j]=f[i-1][j-1];
                    }
                }
            }
        }
        return f[s_len][p_len];
    }
    //i,j从1开始计数，0表示空字符
    public  boolean match(String s,String p,int i,int j){
        if(i==0)return false;
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
