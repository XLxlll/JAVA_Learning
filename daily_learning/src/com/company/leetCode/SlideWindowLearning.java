package com.company.leetCode;

import java.util.HashMap;

/**
 * @title: SlideWindowLearning --滑动窗口
 * @Author Geek_Ling
 * @Date: 2020/8/8 17:08
 * @Version 1.0
 */
public class SlideWindowLearning {
    public static void main(String[] args) {
       String  S = "ADOBECODEBANC", T = "ABC";
        System.out.println(new SlideWindowLearning().minWindow(S,T));
    }
    /**
     * @description 567. Permutation in String
     * @param s1
     * @param s2
     * @return boolean
     * @author Geek_Ling
     * @date 2020/8/9
     */

   /* public boolean checkInclusion(String s1, String s2) {

    }*/
    /**
     * @description 76. Minimum Window Substring
     * 给你一个字符串S、一个字符串T，请在字符串S里面找出：包含T所有字母的最小子串
     * 如果S中不存在这样的子串，返回“”
     * @param s
     * @param t
     * @return java.lang.String
     * @author Geek_Ling
     * @date 2020/8/8
     */

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        char[] chars= s.toCharArray();
        char[] chart = t.toCharArray();
        //needs记录T中字符出现次数，window记录窗口中相应字符出现的次数,
        HashMap<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
        //初始化needs
        for (char c: chart) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        //初始化窗口的两端[left,right)
        int left = 0, right = 0;
        //窗口中满足need条件的字符个数，如果valid和need.size()大小相同，则说明窗口已满足条件，已经完全覆盖了串T
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0,len = Integer.MAX_VALUE;
        while (right < chars.length){
            //将要移入窗口的字符
            char ch = chars[right];
            //窗口右端开始滑动
            right++;
            //如果该字符在need中，
            if (need.containsKey(ch)) {
                //窗口，加入该字符---window并没有记录所有的字符，所以该字符在need中存在才加入
                window.put(ch,window.getOrDefault(ch,0)+1);
                //window.get(ch) 得到的是一个Integer对象，那么使用==比较的时候，会判断地址，Integer只会缓存-128~127之间的数值，当超过这个区间的值后，就会new一个对象，出现地址不一致
                if (window.get(ch).intValue() == need.get(ch).intValue()) valid++;
            }
            //判断窗口左端是否需要收缩；
            while (valid == need.size()){
                //需要收缩，则说明，找到了一个窗口包含了T串中的所有字符，
                //因为要求最小的窗口，那么需要判断当前找到的这个窗口大小与之前存在的窗口大小的值进行比较
                if (right-left < len){
                    //如果当前窗口的值小于之前找到的，那么更新
                    start = left;
                    len = right - left;
                }
                //cr -将要移除窗口的字符
                char cr = chars[left];
                left ++ ;
                if (need.containsKey(cr)){
                    if (window.get(cr).intValue() == need.get(cr).intValue()){
                        valid --;
                    }
                    window.put(cr,window.get(cr)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "":s.substring(start,start+len);
    }
}
