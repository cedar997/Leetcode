package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

public class T206 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        ListNode listNode = ListNode.genList(nums);
        ListNode listNode_reverse = new T206().new Solution().reverseList2(listNode);
        listNode_reverse.print();

    }
    class Solution {
        //采用迭代方式
        public ListNode reverseList2(ListNode head) {
            ListNode pre=null;
            ListNode cur=head;
            ListNode next=head;
            while (cur!=null){
                next=cur.next;
                cur.next=pre;

                pre=cur;
                cur=next;
            }
            //最后cur为null
            return pre;
        }
        public ListNode reverseList(ListNode head) {
            if(head==null)
                return null;
            return reverse(head);
        }
        //采用递归方式
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
