package com.cedar.leetcode.hard;

import java.util.*;

public class T803 {
    static int [][] grid,hits;
    public static void main(String[] args) {

        grid=new int[][]{{1,0,0,0},{1,1,1,0}};
        hits=new int[][]{{1,0}};
        test("[2]");
        grid=new int[][]{{1,0,1},{1,1,1}};
        hits=new int[][]{{0,0},{0,2},{1,1}};
        test("[0,3,0]");
        grid=new int[][]{{1},{1},{1},{1},{1}};
        hits=new int[][]{{3,0},{4,0},{1,0},{2,0},{0,0}};
        test("[1,0,1,0,0]");
        grid=new int[][]{{0,1,1,1,1},{1,1,1,1,0},{1,1,1,1,0},{0,0,1,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        hits=new int[][]{{6,0},{1,0},{4,3},{1,2},{7,1},{6,3},{5,2},{5,1},{2,4},{4,4},{7,3}};
        test("[0,0,0,0,0,0,0,0,0,0,0]");
    }
    private static boolean test(String ans){
        int[] hitBricks = new T803().new Solution().hitBricks(grid, hits);
        System.out.println("hitBricks = " + Arrays.toString(hitBricks));
        System.out.println("ans = " + ans);
        return true;
    }
    //废弃
    class Solution2 {
        public static final int T=1000;

        public int[] hitBricks(int[][] grid, int[][] hits) {

            //存放砖块
            List<Integer> ones=new ArrayList<>();

            for(int i=0;i< grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1){
                        ones.add(i*T+j);
                    }
                }
            }
            final int n=hits.length;
            int []  ret=new int[n];
            for(int i=0;i<n;i++){

                int [] visited=new int[ones.size()];
                dfs(ones,hits[i][0]*T+hits[i][1],0,visited);
                int count=0;
                for (int j = 0; j < visited.length; j++) {
                    if(visited[j]==-1){
                        count++;
                        ones.remove(j);
                    }
                }
                ret[i]=count;
            }
            return ret;


        }
        private boolean connect(int x,int y){
            if((x-y)%T==0)
                return true;
            if((x/T==y/T))
                return true;
            return false;
        }
        private boolean stable(int x){
            return x<T;
        }
        private int dfs(List<Integer> ones,int  hit,int i,int visited[]){
            int t=ones.get(i);
            if(stable(t))
                return 1;


            return -1; //代表不稳定
        }
    }
    //还是不行
    class Solution3{
        int m;
        int n;
        public int[] hitBricks(int[][] grid, int[][] hits) {

            final int hit_count=hits.length; //打砖数
            int ret[]=new int [hit_count];
            m=grid.length;
            n=grid[0].length;
            int [][] gridd=new int[m][n];
            for(int h=0;h<hit_count;h++){

                final int hit_row=hits[h][0];
                final int hit_col=hits[h][1];
                grid[hit_row][hit_col]=0; //
                boolean empty=true;
                for(int i=0;i<n;i++){

                    if(grid[0][i]==1 ){
                        gridd[0][i]=1;



                        dfs(grid,gridd,1,i);
                        empty=false;
                    }
                }
                if(empty){
                    gridd=new int[m][n];

                }
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if(grid[i][j]!=gridd[i][j]){
                            grid[i][j]=0;
                            gridd[i][j]=0;
                            ret[h]++;
                        }
                    }
                }

                //System.out.println("h = " + h);;for (int [] s:gridd) System.out.println(Arrays.toString(s));

            }
            return ret;
        }
        private void dfs(int [][] grid,int [][] gridd,int i,int j){
            if(grid[i][j]==0)
                return;
            Stack<Integer> stack=new Stack<>();
            gridd[i][j]=1;
            do {
                //向下
                if (j + 1 < n && grid[i][j + 1] == 1 && gridd[i][j + 1] == 0) {
                    j++;
                    stack.push(i*1000+j);

                }
                //向上
                else if (j > 0 && grid[i][j - 1] == 1 && gridd[i][j - 1] == 0) {
                    j--;
                    stack.push(i*1000+j);

                }
                //向左
                else if (i > 0 && grid[i - 1][j] == 1 && gridd[i - 1][j] == 0) {
                    i--;
                    stack.push(i*1000+j);

                }
                //向右
                else if (i + 1 < m && grid[i + 1][j] == 1 && gridd[i + 1][j] == 0) {
                    i++;
                    stack.push(i*1000+j);

                }
                else {
                    if(!stack.isEmpty()){
                        int poll = stack.pop();
                        i=poll/1000;
                        j=poll%1000;
                    }

                }
                gridd[i][j]=1;
            }while (!stack.isEmpty());
        }
    }

    //官方并查集
    class Solution {

        private int rows;
        private int cols;

        public  final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int[] hitBricks(int[][] grid, int[][] hits) {
            this.rows = grid.length;
            this.cols = grid[0].length;

            // 第 1 步：把 grid 中的砖头全部击碎，通常算法问题不能修改输入数据，这一步非必需，可以认为是一种答题规范
            int[][] copy = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    copy[i][j] = grid[i][j];
                }
            }

            // 把 copy 中的砖头全部击碎
            for (int[] hit : hits) {
                copy[hit[0]][hit[1]] = 0;
            }

            // 第 2 步：建图，把砖块和砖块的连接关系输入并查集，size 表示二维网格的大小，也表示虚拟的「屋顶」在并查集中的编号
            int size = rows * cols;
            UnionFind unionFind = new UnionFind(size + 1);

            // 将下标为 0 的这一行的砖块与「屋顶」相连
            for (int j = 0; j < cols; j++) {
                if (copy[0][j] == 1) {
                    unionFind.union(j, size);
                }
            }

            // 其余网格，如果是砖块向上、向左看一下，如果也是砖块，在并查集中进行合并
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (copy[i][j] == 1) {
                        // 如果上方也是砖块
                        if (copy[i - 1][j] == 1) {
                            unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                        }
                        // 如果左边也是砖块
                        if (j > 0 && copy[i][j - 1] == 1) {
                            unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                        }
                    }
                }
            }

            // 第 3 步：按照 hits 的逆序，在 copy 中补回砖块，把每一次因为补回砖块而与屋顶相连的砖块的增量记录到 res 数组中
            int hitsLen = hits.length;
            int[] res = new int[hitsLen];
            for (int i = hitsLen - 1; i >= 0; i--) {
                int x = hits[i][0];
                int y = hits[i][1];

                // 注意：这里不能用 copy，语义上表示，如果原来在 grid 中，这一块是空白，这一步不会产生任何砖块掉落
                // 逆向补回的时候，与屋顶相连的砖块数量也肯定不会增加
                if (grid[x][y] == 0) {
                    continue;
                }

                // 补回之前与屋顶相连的砖块数
                int origin = unionFind.getSize(size);

                // 注意：如果补回的这个结点在第 1 行，要告诉并查集它与屋顶相连（逻辑同第 2 步）
                if (x == 0) {
                    unionFind.union(y, size);
                }

                // 在 4 个方向上看一下，如果相邻的 4 个方向有砖块，合并它们
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (inArea(newX, newY) && copy[newX][newY] == 1) {
                        unionFind.union(getIndex(x, y), getIndex(newX, newY));
                    }
                }

                // 补回之后与屋顶相连的砖块数
                int current = unionFind.getSize(size);
                // 减去的 1 是逆向补回的砖块（正向移除的砖块），与 0 比较大小，是因为存在一种情况，添加当前砖块，不会使得与屋顶连接的砖块数更多
                res[i] = Math.max(0, current - origin - 1);

                // 真正补上这个砖块
                copy[x][y] = 1;
            }
            return res;
        }

        /**
         * 输入坐标在二维网格中是否越界
         *
         * @param x
         * @param y
         * @return
         */
        private boolean inArea(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

        /**
         * 二维坐标转换为一维坐标
         *
         * @param x
         * @param y
         * @return
         */
        private int getIndex(int x, int y) {
            return x * cols + y;
        }

        private class UnionFind {

            /**
             * 当前结点的父亲结点
             */
            private int[] parent;
            /**
             * 以当前结点为根结点的子树的结点总数
             */
            private int[] size;

            public UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            /**
             * 路径压缩，只要求每个不相交集合的「根结点」的子树包含的结点总数数值正确即可，因此在路径压缩的过程中不用维护数组 size
             *
             * @param x
             * @return
             */
            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return;
                }
                parent[rootX] = rootY;
                // 在合并的时候维护数组 size
                size[rootY] += size[rootX];
            }

            /**
             * @param x
             * @return x 在并查集的根结点的子树包含的结点总数
             */
            public int getSize(int x) {
                int root = find(x);
                return size[root];
            }
        }
    }


}
