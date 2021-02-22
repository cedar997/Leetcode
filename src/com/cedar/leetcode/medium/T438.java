package com.cedar.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438 {

    public static void main(String[] args) {
        String s="cbaebabacd", p= "abc";
        System.out.println(new T438().new Solution().findAnagrams(s, p));
    }
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            List<Integer> ret=new ArrayList<>();
            for (char c : p.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            //System.out.println(need);
            int left = 0;
            int right = 0;
            int valid = 0;
            int len = Integer.MAX_VALUE;
            int start = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)) ) {
                        valid++;
                    }
                }
                while (right-left>=p.length()) {
                    if (valid==need.size()) {
                        ret.add(left);
                    }
                    char d=s.charAt(left);

                    left++;
                    if (need.containsKey(d)) {
                        if (need.get(d) .equals(window.get(d)) ) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }


            return ret;
        }

    }
}
