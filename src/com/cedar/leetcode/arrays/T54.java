package com.cedar.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
/*
54. 螺旋矩阵
 */
public class T54 {
    public static void main(String[] args) {
        int [][] matrix = {{3},{2}};
        System.out.println(new T54().new Solution().spiralOrder(matrix));
    }
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            List<Integer> ret=new ArrayList<>();
            //起点从（0，-1）进入
            int i=0,j=-1;
            while(m>1 && n>1){
                //先加可以省去边界检查
                //向右n
                for (int k = 0; k < n; k++)
                    ret.add(matrix[i][++j]);
                //向下m-1
                for (int k = 0; k < m-1; k++)
                    ret.add(matrix[++i][j]);
                //向左n-1
                for (int k = 0; k < n-1; k++)
                    ret.add(matrix[i][--j]);
                //向上m-2
                for (int k = 0; k < m-2; k++)
                    ret.add(matrix[--i][j]);
                //缩小一圈
                m-=2;
                n-=2;
            }
            //处理行残余
            if(m==1 ){
                for (int k = 0; k < n; k++)
                    ret.add(matrix[i][++j]);
                n=0;
            }
            //处理列残余
            if(n==1 ){
                j++;
                for (int k = 0; k < m; k++)
                    ret.add(matrix[i++][j]);
            }
            return ret;
        }
    }
}
