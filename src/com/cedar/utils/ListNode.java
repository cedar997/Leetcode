package com.cedar.utils;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode genList(int...args){
        if(args.length==0) return null;
        ListNode head=new ListNode(args.length);

        ListNode p=head;
        for (int i:args) {
            ListNode node=new ListNode(i);
            p.next=node;
            p=node;
        }
        return head.next;
    }
    public  void  println(){
        if(this==null) return;
        ListNode p=this;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public  void  print(){
        if(this==null) return;
        ListNode p=this;
        while (p!=null){
            System.out.print(p.val);
            p=p.next;
            if(p!=null) System.out.print(" -> ");
        }
    }
    public static void  print(ListNode head){
        if(head==null) return;
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
