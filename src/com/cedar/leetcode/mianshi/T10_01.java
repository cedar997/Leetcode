package com.cedar.leetcode.mianshi;

public class T10_01 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i=m-1;
            int j=n-1;
            int k=A.length-1;
            while(k>=0 && j>=0 && i>=0){
                if(A[i]>B[j]){
                    A[k]=A[i--];
                }else{
                    A[k]=B[j--];
                }
                k--;
            }
            while(i<0 && j>=0){
                A[k--]=B[j--];
            }
        }
    }
}
