package com.cedar.leetcode.linklist;

import com.cedar.utils.ListNode;

public class T25 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6,7,8,9};
        ListNode listNode = ListNode.genList(nums);
        ListNode listNode_reverse = new T25().new Solution().reverseKGroup(listNode,3);
        listNode_reverse.print();
    }
    class Solution {
        //采用迭代方式
        public ListNode reverse(ListNode head,ListNode end) {
            ListNode pre=null;
            ListNode cur=head;
            ListNode next=head;
            while (cur!=end){
                next=cur.next;
                cur.next=pre;

                pre=cur;
                cur=next;
            }
            //最后cur为null
            return pre;
        }
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null)
                return null;
            ListNode a,b;
            a=b=head;
            for (int i = 0; i < k; i++) {
                //不足k个，不需要反转，base，到末尾了，开始回溯
                if(b==null)
                    return head;
                b=b.next;
            }
            ListNode newHead = reverse(a, b);
            //反转后a作为单元的末尾
            a.next=reverseKGroup(b,k);
            return newHead;
        }
    }
}
