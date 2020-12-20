package com.cedar.leetcode.medium;

public class T316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String s1 = new Solution().removeDuplicateLetters(s);
        System.out.println(s1);
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        boolean[] vis = new boolean[26];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++)
            count[chars[i] - 'a']++;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!vis[ch - 'a']) {

                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > chars[i]) {
                    if (count[sb.charAt(sb.length()-1)-'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else
                        break;

                }
                vis[ch - 'a'] = true;
                sb.append(chars[i]);
            }
            count[ch-'a']--;

        }
        return sb.toString();
    }

}