package com.cedar.leetcode.tmp.t_06;


/**
 * @author xxs
 * @date 2020/09/11
 **/
public class ZTrans {
    public String convert(String s, int numRows) {
        int len = s.length() - 1;
        //每个周期含有的元素个数，当三行时为4个
        int x = 2 * numRows - 2;
        //每个周期含有的列数，当三行时为2列
        int y = numRows - 1;
        //含有多少个完整的周期
        int a = len / x;
        //最后残余周期含有的元素个数
        int b = len % x;
        //矩阵列数
        int c = 0;
        //当残余元素先将第一列填满，因此列数只会加1
        if (b < numRows) c = a * y + 1;
            //第一列填满后，每多一个元素，会多一列
        else c = a * y + b - numRows + 2;
        //使用稀疏的矩阵来存储。
        char[][] arr = new char[numRows][c];
        //给数组填充数据
        for (int i = 0; i <= len; i++) {
            //第几个周期
            int e = i / x;
            //是残余周期的第几个元素
            int d = i % x;
            if (d < numRows)
                //先填满第一列
                arr[d][y * e] = s.charAt(i);
            else
                //在从左下角往左上角填充
                arr[x - d][y * e + d - numRows + 1] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //如果当前字符不为0，则添加到输出序列
                if (arr[i][j] != 0)
                    sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }

    public void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String s1 = convert(s, 5);
        System.out.println(s1);
    }


}
