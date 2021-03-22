package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

/*
61. 旋转链表
 */
public class T61 {
    public static void main(String[] args) {
        int [] nums={0,1,2};
        ListNode listNode = ListNode.genList(nums);
        ListNode listNode_reverse = new T61().new Solution().rotateRight(listNode,4);
        listNode_reverse.print();
    }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null)
                return null;
            ListNode p=head;
            ListNode new_head_prev=head;
            ListNode end=head;
            int i=0;
            while (p!=null){
                i++;
                end=p;
                p=p.next;
            }

            k=i-k%i;
            if(k==i){
                return head;
            }
            p=head;
            while ( k>0){
                new_head_prev=p;
                p=p.next;
                k--;
            }

            ListNode new_head= new_head_prev.next;
            new_head_prev.next=null;
            end.next=head;
            return new_head;
        }
    }
}
