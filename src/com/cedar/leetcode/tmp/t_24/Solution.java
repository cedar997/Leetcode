package com.cedar.leetcode.tmp.t_24;
import com.cedar.utils.ListNode;
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode third=swapPairs(head.next.next);
        head.next.next=head;
        ListNode ret=head.next;
        head.next=third;
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.genList(1, 2, 3, 4);
        Solution solution = new Solution();
        solution.swapPairs(head).print();
    }
}
