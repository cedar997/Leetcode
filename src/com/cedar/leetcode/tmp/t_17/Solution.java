package com.cedar.leetcode.tmp.t_17;


import java.util.ArrayList;
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
        for (int i = 0; i < digits.length(); i++) {//遍历输入的按键，如8
            char[] s= table[digits.charAt(i) - '0'];//获取当前按键对应的字母，如，tuv
            if(list2.size()==0){//如果list2为空，则从头开始构建
                for(int k=0;k<s.length;k++){
                    list2.add(""+s[k]);//将以按键每个字母构成字符串添加到list2
                    //如，'t','u','v'
                }
            }
            else{//如果list2中有元素，则在原有元素的基础上进行
                Iterator<String> iterator = list2.iterator();
                List<String> other=new ArrayList<>();
                while (iterator.hasNext()){//遍历list2中的每个元素
                    String pre=iterator.next();//获得原先的一个字符串，如't'
                    for(int n=0;n<s.length;n++){//如，当前s='jkl'
                            other.add(pre + s[n]);//构建出更多的字符串，并加入到other列表
                            //如 'tj','tk','tl'
                    }
                }
                list2.clear();//清除之前的元素，
                list2.addAll(other);//加入新构建的元素。
            }
        }
        return list2;
    }
    ///////////////////////////////TEST////////////////////////////

}
