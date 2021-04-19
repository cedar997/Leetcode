package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;
//环形链表
public class T141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head==null) return false;
            ListNode slow=head.next;
            if(slow==null) return false;
            ListNode fast=head.next.next;
            while(fast!=null && fast.next!=null){
                if(fast==slow) return true;
                fast=fast.next.next;
                slow=slow.next;
            }
            return false;

        }
    }
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

}
