package com.cedar.utils;

public class UnionFind {
    private int count;
    private int[] parent;
    private int [] size;
    public UnionFind(int n){
        this.count=n;
        //父节点指针初始指向自己
        parent=new int[n];
        size=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    //将p和q连接,O(1)
    public void union(int p,int q){
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ)
            return;
        if(size[rootP]>size[rootQ]){
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }
        else {
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }

        count--;
    }
    //判断p和q是否连通,O(1)
    public boolean  connected(int p,int q){
        int rootP=find(p);
        int rootQ=find(q);
        return rootP == rootQ;
    }
    //返回图中有多少个连通分量
    public int count(){
        return count;
    }

    private int find(int x){
        //核心代码
        while (parent[x]!=x){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

}
