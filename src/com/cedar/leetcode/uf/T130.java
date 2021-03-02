package com.cedar.leetcode.uf;

import com.cedar.utils.UnionFind;

public class T130 {
    public static void main(String[] args) {
        char[][] testTable = {{'X','X','X','X'},{'X','O','O','X'},
                {'X','X','O','X'},{'X','O','X','X'}};
        for(char[] now:testTable){
            for(char nowc:now){
                System.out.print(nowc+" ");
            }
            System.out.println();
        }
        System.out.println();
        new T130().new Solution().solve(testTable);

        for(char[] now:testTable){
            for(char nowc:now){
                System.out.print(nowc+" ");
            }
            System.out.println();
        }
    }
    class SolutionUf {
        public void solve(char[][] board) {
            if(board.length==0)
                return;
            int m=board.length;
            int n=board[0].length;
            //增加了一个虚拟结点 dummy
            int dummy=m*n;
            UnionFind uf=new UnionFind(m*n+1);

            //首列和末列的‘O'
            for (int i = 0; i < m; i++) {
                if(board[i][0]=='O'){
                    uf.union(i*n,dummy);
                }
                if(board[i][n-1]=='O'){
                    uf.union(i*n+n-1,dummy);
                }
            }
            //首行和末行的’O‘
            for (int j=0;j<n;j++){
                if(board[0][j]=='O')
                    uf.union(j,dummy);
                if(board[m-1][j]=='O')
                    uf.union((m-1)*n+j,dummy);
            }
            //方向数组
            int [][] d={{1,0},{0,1},{0,-1},{-1,0}};
            for (int i = 1; i < m-1; i++) {
                for(int j=1;j<n-1;j++){
                    if(board[i][j]=='O'){
                        for (int k=0;k<4;k++){
                            int x=i+d[k][0];
                            int y=j+d[k][1];
                            if(board[x][y]=='O')
                                uf.union(x*n+y,i*n+j);
                        }
                    }
                }
            }
            for (int i = 1; i < m-1; i++) {
                for(int j=1;j<n-1;j++){
                    if(!uf.connected(dummy,i*n+j)){
                        board[i][j]='X';
                    }
                }
            }
        }
    }
    class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            //首列和末列
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            //首行和末行
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //A表示:没有被字母 X 包围的字母 O
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y); //右
            dfs(board, x - 1, y); //左
            dfs(board, x, y + 1); //上
            dfs(board, x, y - 1); //下
        }
    }


}
