package com.company.test;

import java.util.Scanner;

/**
 * @title: T1
 * @Author Geek_Ling
 * @Date: 2020/8/5 20:34
 * @Version 1.0
 */
public class T1 {
    public static void main(String[] args) {
        T1 t = new T1();
        System.out.println("true=="+t.isMatch("aaabb","aaabb"));
        System.out.println("true=="+t.isMatch("",""));
        System.out.println("false=="+t.isMatch("aaaabb","aaabbcv"));
       System.out.println("false=="+t.isMatch("aaabb","aaabbbbbbbbbbbb"));
        //a*出现0次
        System.out.println("false=="+t.isMatchR("aaabb","aaabba*"));
    }
    /**
     * @description --递归形式
     * @param text
     * @param pattern
     * @return boolean
     * @author Geek_Ling
     * @date 2020/8/6
     */

    private boolean isMatchR(String text,String pattern){
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) =='.');
        //模式串中有*，那么他会出现在第二个位置
        if (pattern.length() >=2 && pattern.charAt(1) == '*')
            //忽略模式串中星号的这一部分，或者删除匹配串的第一个字符
            return isMatchR(text,pattern.substring(2)) || (first_match && isMatchR(text.substring(1),pattern));
        else
            //p中没有*
            return first_match && isMatchR(text.substring(1),pattern.substring(1));
    }
    /**
     * @description --
     * 判断这两个字符串是否匹配
     * @param text
     * @param pattern
     * @return boolean
     * @author Geek_Ling
     * @date 2020/8/6
     */

    private boolean isMatch(String text,String pattern){
        //pattern是空的，若text也是空的话，就返回true匹配，text不为空的话，返回false
        if (pattern.isEmpty()) return text.isEmpty();
        int i = 0;
        int j = 0;
        char[] tc = text.toCharArray();
        char[] pc = pattern.toCharArray();

        while (j<pc.length){
            //若pattern还有字符，但是text已经没有字符了，那么肯定不匹配
            if (i >= tc.length) {
                return false;
            }

            if (pc[j++] != tc[i++]) return false;
        }
        //此时pattern字符串已经遍历结束，如果此时j整好等于text的长度，那么pattern与text完全匹配
        return j == tc.length;
    }
}
