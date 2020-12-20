package com.cedar.leetcode.tmp.t_07;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xxs
 * @date 2020/09/11
 **/
public class Reverse {
    public int reverse(int x) {
        System.out.println("x = " + x);
        boolean isNeg=false;
        if(x<0){
            isNeg=true;
            x=-x;
        }
        List<Integer> arr=new ArrayList<Integer>();


        while(true){
            int q=x/10;
            int s=x%10;
            if(x>0){
                arr.add(s);
            }
            else {
                break;
            }
            x=q;
        }
        long rev=0;
        Iterator<Integer> it= arr.iterator();
        while (it.hasNext()){
            rev=rev*10+it.next();
        }
        if(rev>Integer.MAX_VALUE)return 0;
        int ret=(int)rev;
        return isNeg?(-ret):ret;
    }


    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

/*
    作者：guanpengchn
    链接：https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
}
