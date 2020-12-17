package com.cedar.leetcode.t_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xxs
 * @Date 2020/10/9
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        List<Integer> combine=new ArrayList<>();
        dfs(candidates,target,list,combine,0);
        return list;
    }
    
    public void dfs(int []candidates,int target,List<List<Integer>> ans,List<Integer>combine,int idx){
        if(idx==candidates.length) return;
        if(0==target){ //found a combine
            ans.add(new ArrayList<>(combine));
            return;
        }
        //dive down to stack bottom
        
       dfs(candidates,target,ans,combine,idx+1);
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            combine.remove(combine.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] candidates={2,3,6,7};
        int target=7;
        List<List<Integer>> list= new Solution().combinationSum(candidates,target);
        System.out.println(list.toString());

    }
}
