package com.cedar.leetcode.t_17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author xxs
 * @date 2020/09/13
 * 17. 电话号码的字母组合
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class Solution {

    public List<String> letterCombinations(String digits) {

        char [][] table={{'_'},{'!','@','#'}, {'a','b','c'}, {'d','e','f'},
                {'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'},
        };
        List<String>list2=new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] s= table[digits.charAt(i) - '0'];
            if(list2.size()==0){
                for(int k=0;k<s.length;k++){
                    list2.add(""+s[k]);
                }
            }
            else{
                Iterator<String> iterator = list2.iterator();
                List<String> other=new ArrayList<>();
                while (iterator.hasNext()){
                    String pre=iterator.next();
                    for(int n=0;n<s.length;n++){

                            other.add(pre + s[n]);
                    }
                }
                list2.clear();
                list2.addAll(other);
            }
        }
        return list2;
    }
    ///////////////////////////////TEST////////////////////////////


    @Test
    public void test(){
        String s="23";

        System.out.println(letterCombinations(s));
    }
}
