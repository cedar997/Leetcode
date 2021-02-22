package com.cedar.leetcode.simple;

public class T605 {
    public static void main(String[] args) {
        int flowerbed[] = {1,0,0,1,0};

        int n = 2;
        System.out.println(new T605().canPlaceFlowers(flowerbed,n));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
            return true;
        if(flowerbed.length<2*n-1)
            return false;

        if(flowerbed.length==1)
            return flowerbed[0]==0;

        int sum=0;
        int prev=0;
        int next;
        for(int i=0;i<flowerbed.length;i++){
            if(i+1<flowerbed.length){
                next=flowerbed[i+1];
            }
            else
                next=0;
            if(prev==0 && flowerbed[i]==0 && next==0){
                sum++;
                if(sum>=n)
                    return true;
                i++;
                continue;
            }
            prev=flowerbed[i];

        }
        return false;
    }
}
