package com.cedar.leetcode.t_19;

import org.junit.Test;

//19. 删除链表的倒数第N个节点
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret=head;
        ListNode del=head;
        int i=0;
        while(head!=null){
            if(i>n){
                del=del.next;
            }
            head=head.next;
            i++;
        }
        if(i<=n){
            return ret.next;
        }
        deleteAfter(del);
        return ret;
    }
    //删除该元素后面的元素
    public void deleteAfter(ListNode head){
        if(head.next==null){
            return;
        }
        else if(head.next.next==null){
            head.next=null;
        }
        else{
            head.next=head.next.next;
        }
    }
/////////////

    @Test
    public void test(){

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
