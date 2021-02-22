package com.cedar.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {
    public static void main(String[] args) {
        List<List<String>> lists = new T51().new Solution().solveNQueens(4);
        System.out.println(lists);
    }
    class Solution {
        List<List<String>> res;
        public List<List<String>> solveNQueens(int n) {
            res=new ArrayList<>();
            char[][] board=new char[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    board[i][j]='.';
                }
            }
            backtrace(board,0);
            return res;
        }
        void backtrace(char[][] board,int row){


            if(row==board.length){
                List<String> list=new ArrayList<>();
                for(int i=0;i<board.length;i++){
                    String s=String.valueOf(board[i]);
                    list.add(s);
                }

                res.add(list);
                return;
            }
            int n=board[row].length;

            for(int col=0;col<n;col++){
                if(!isValid(board,row,col))
                    continue;
                board[row][col]='Q';
                backtrace(board,row+1);
                board[row][col]='.';

            }

        }
        boolean isValid(char [][] board,int row,int col){
            int n=board.length;

            //检查列是否有冲突
            for(int i=0;i<n;i++){
                if(board[i][col]=='Q'){
                    return false;
                }
            }
            //右上
            for(int i=row-1,j=col+1;i>=0 &&j<n;i--,j++){
                if(board[i][j]=='Q')
                    return false;
            }
            //左上
            for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
                if(board[i][j]=='Q')
                    return false;
            }
            return true;
        }
    }
}
