package com.cedar.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class T76 {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new T76().new Solution().minWindow(s, t));
    }
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (char c : t.toCharArray()) {
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
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (need.get(d) .equals(window.get(d)) ) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }


            return len==Integer.MAX_VALUE? "":s.substring(start,start+len);
        }
    }
}
