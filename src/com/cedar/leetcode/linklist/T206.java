package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

public class T206 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        ListNode listNode = ListNode.genList(nums);
        ListNode listNode_reverse = new T206().new Solution().reverseList(listNode);
        listNode_reverse.print();

    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null)
                return null;
            return reverse(head);
        }
        ListNode reverse(ListNode head) {
            if(head.next==null)
                return head;
            ListNode end=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return end;
        }
    }
}
