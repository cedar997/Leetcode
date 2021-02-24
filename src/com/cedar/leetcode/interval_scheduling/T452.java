package com.cedar.leetcode.interval_scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    public static void main(String[] args) {
        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(new T452().new Solution().findMinArrowShots(points));
    }
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if(points.length==0) return 0;
            //按照end升序
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            int count=1;
            int x_end=points[0][1];
            for(int [] p : points){
                int start=p[0];
                if(start>=x_end){
                    count++;
                    x_end=p[1];
                }
            }
            return count;
        }
    }
}
