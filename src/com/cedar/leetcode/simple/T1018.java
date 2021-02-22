package com.cedar.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1018 {
    public static void main(String[] args) {
        int [] s=new int []{1,1,0,0,0,1,0,0,1};
        System.out.println("new T1018().prefixesDivBy5(s) = " + new T1018().prefixesDivBy5(s));
    }
    public List<Boolean> prefixesDivBy5(int[] A) {
        final int n=A.length;
        Boolean [] ret=new Boolean[n];

        int temp=A[0];
        ret[0]=A[0]==0;

        for(int i=1;i<n;i++){
            temp=(temp*2+A[i])%5;
            if(temp==0){
                ret[i]=true;
            }
            else {
                ret[i]=false;
            }
        }
        return Arrays.asList(ret);
    }
}
