package com.cedar.leetcode.t_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if(n==0){
            ans.add("");
            return ans;
        }
        for (int i = 0; i < n; i++) {
            for (String left:generateParenthesis(i)
                 ) {
                for (String right:generateParenthesis(n-i-1)
                     ) {
                    ans.add(String.format("(%s)%s", left,right));
                }
            }
        }
        return ans;
    }
//    def generateParenthesis(self, n: int) -> List[str]:
//            if(n==0):
//            return [""]
//    ans=[]
//            for c in range(n):
//            for left in self.generateParenthesis(c):
//            for right in self.generateParenthesis(n-c-1):
//            ans.append("({}){}".format(left,right))
//            return ans
}
