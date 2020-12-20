package com.cedar.leetcode.t_09;



/**
 * @author xxs
 * @date 2020/09/12
 **/
public class SolutionOthers {
    public void test(){
        int i=454;
        boolean b=isPalindrome(i);
        System.out.println(b);
    }

    /*
    作者：reedfan
    链接：https://leetcode-cn.com/problems/palindrome-number/solution/ji-bai-liao-99de-javayong-hu-dai-ma-you-ya-by-reed/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        //用tem记录 位数+1
        //help记录最大的十的幂
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            //比较末位  和  首位
            if (x % 10 != x / help) { //
                return false;
            }
            //截去首末
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }

}
