package com.cedar.leetcode.t_06;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xxs
 * @date 2020/09/11
 **/
public class ZTrans {
    public String convert(String s,int numRows){
        int len=s.length()-1;
        int x=2*numRows-2;//每个单元元素个数
        int y=numRows-1;//每个单元列数
        int a=len/x;//重复单元个数
        int b=len%x;
        int c=0;//矩阵列数

        if(b<numRows)c=a*y+1;
        else c=a*y+b-numRows+2;
        char [][]arr=new char[numRows][c];
        //给数组填充数据
        for(int i=0;i<=len;i++){
            int d=i%x;
            int e=i/x;

            if(d<numRows){
                arr[d][y*e]=s.charAt(i);
            }
            else {
                arr[x - d][y * e + d - numRows + 1] = s.charAt(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }
    @Test
    public void test1(){
        String s="LEETCODEISHIRING";
        int numRows=3;
        String s1 = convert(s, 5);
        System.out.println(s1);
    }
}
