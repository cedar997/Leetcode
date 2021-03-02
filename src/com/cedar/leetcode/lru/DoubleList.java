package com.cedar.leetcode.lru;
//Node 类型构建一个双链表
public class DoubleList {
    private Node head,tail;
    private int size;

    public DoubleList() {
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    //将结点x放到tail结点之前
    public void addLast(Node x){
        //插入4行
        x.prev=tail.prev;
        x.next=tail;
        tail.prev.next=x;
        tail.prev=x;

        size++;
    }
    //x一定存在的情况下，移除x结点
    public void remove(Node x){
        //删除2行
        x.prev.next=x.next;
        x.next.prev=x.prev;

        size--;
    }
    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if(head.next==tail){
            return null;
        }
        Node first=head.next;
        remove(first);
        return first;
    }

    public int size(){
        return size;
    }
}
