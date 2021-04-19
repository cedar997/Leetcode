package com.cedar.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//89. 格雷编码
public class T89 {
    public static void main(String[] args) {
        int n=2;
        System.out.println(new T89().new Solution().grayCode(n));
    }
    class Solution_erro {
        boolean visited[];
        int m;
        List<Integer> ret=new ArrayList<>();
        public List<Integer> grayCode(int n) {
            m=1<<n;
            visited=new boolean[m];
            helper(visited);
            return ret;
        }
        private void helper(boolean visited[]){



            for (int i = 0; i < visited.length; i++) {
                visited[i]=!visited[i];
                int p=1;
                int sum=0;
                for(boolean b :visited){
                    if(b)
                        sum+=p;
                    p<<=1;
                }
                if(!ret.contains(sum))
                    ret.add(sum);
                if(ret.size()==m){
                    return;
                }
                helper(visited);
                visited[i]=!visited[i];
            }
        }

    }
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
            int head = 1;
            for (int i = 0; i < n; i++) {
                //下一阶 = 上一阶 + （ head + 上一阶的倒序 ）
                for (int j = res.size() - 1; j >= 0; j--)
                    res.add(head + res.get(j));
                head <<= 1;
            }
            return res;
        }
    }
}


