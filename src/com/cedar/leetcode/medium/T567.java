package com.cedar.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class T567 {
    public static void main(String[] args) {
        String s1 = "ab",s2 = "eidboaoo";
        System.out.println(new T567().new Solution().checkInclusion(s1, s2));
    }
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            //System.out.println(need);
            int left = 0;
            int right = 0;
            int valid = 0;
            int len = Integer.MAX_VALUE;
            int start = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)) ) {
                        valid++;
                    }
                }
                while (right-left>=s1.length()) {
                    if (valid==need.size()) {
                        return true;
                    }
                    char d=s2.charAt(left);

                    left++;
                    if (need.containsKey(d)) {
                        if (need.get(d) .equals(window.get(d)) ) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }


            return false;
        }
    }
}
