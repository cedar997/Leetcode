package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

public class T92 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        ListNode listNode = ListNode.genList(nums);
        ListNode listNode_reverse = new T92().new Solution().reverseBetween(listNode,2,4);
        listNode_reverse.print();
    }
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==1){
                return reverseN(head,right);
            }
            head.next= reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
        ListNode temp;
        //反转前n个结点
        ListNode reverseN(ListNode head, int n) {
            if(n==1){
                temp=head.next;
                return head;
            }

            ListNode end=reverseN(head.next,n-1);
            head.next.next=head;
            head.next=temp;
            return end;
        }
    }
}
