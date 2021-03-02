package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

public class T234 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6,7,8,9};
        ListNode listNode = ListNode.genList(nums);
        boolean listNode_reverse = new T234().new Solution().isPalindrome(listNode);
        System.out.println(listNode_reverse);
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            //1、先找到链表的中点
            ListNode slow,fast;
            slow=fast=head;
            while (fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            //对奇数链表，跳过真正的中点
            if(fast!=null){
                slow=slow.next;
            }

            ListNode left=head;
            //2、将后半部分进行翻转，并进行回文比较
            ListNode right=reverse(slow);
            while (right!=null){
                if(left.val != right.val)
                    return false;
                left=left.next;
                right=right.next;

            }
            return true;
        }
        ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode cur=head;
            while (cur !=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return pre;
        }

    }
}
