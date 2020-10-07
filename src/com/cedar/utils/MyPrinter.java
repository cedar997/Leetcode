package com.cedar.utils;

public class MyPrinter {
    public static void  print(ListNode head){
        if(head==null) return;
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
