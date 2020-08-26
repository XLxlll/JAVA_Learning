package com.company.leetCode;

import com.company.base.TreeNode;

import java.util.*;

/**
 * @title: BFSLearning _BFS学习技巧
 * @Author Geek_Ling
 * @Date: 2020/8/17 9:17
 * @Version 1.0
 */
public class BFSLearning {
    public static void main(String[] args) {
        BFSLearning bfsLearning = new BFSLearning();
        int[][] board = {{4,1,2},{5,0,3}};
        System.out.println(bfsLearning.slidingPuzzle(board));
    }
    int slidingPuzzle(int[][] board){
        int m = 2;
        int n =3;
        StringBuffer buffer = new StringBuffer();
        String target = "123450";
        //将2*3的数组转化成字符串
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                buffer.append(board[i][j]);
            }
        }
        String start = buffer.toString();
        //记录一维字符串的相邻索引，画出2维的图来，看看该位置上下左右的索引
        int[][] neighbor = {
                {1,3},
                {0,4,2},
                {1,5},
                { 0, 4 },
                { 3, 1, 5 },
                { 4, 2 }
        };
        //开始BFS算法
        //关键的数据结构——队列
        Queue<String> queue = new LinkedList<>();
        //避免走回头路
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur =  queue.poll();
                //到达target结束条件
                if (cur.equals(target)){
                    return step;
                }
                //找到数字0的索引
                int idx = 0;
                for (;cur.charAt(idx) != '0';idx++);
                //将数据0和相邻的数字交换位置
                for (int adj : neighbor[idx]){
                  String new_board = swap(cur,adj,idx);
                    //防止走回头路
                    if (!visited.contains(new_board)){
                        queue.offer(new_board);
                        visited.add(new_board);
                    }
                }

            }
            step ++;
        }
        return -1;
    }

    private String swap(String new_board, int adj, int idx) {
        char[] chars = new_board.toCharArray();
        char temp = chars[adj];
        chars[adj] = chars[idx];
        chars[idx] = temp;
       return new String(chars);
    }

    /**
     * @description 111. Minimum Depth of Binary Tree
     * The minimum depth is the number of nodes
     * along the shortest path from the root node down to the nearest leaf node.
     * @param root
     * @return int
     * @author Geek_Ling
     * @date 2020/8/17
     */

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;
        while (!queue.isEmpty()){
            int qs = queue.size();
            for (int i = 0; i <qs; i++) {
                //remove()与poll的区别是当对象为null时，remove()会抛出异常
                TreeNode cur = queue.poll();
                //结束条件
                if (cur.left == null && cur.right == null) return ans;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans++;
        }
        return ans;
    }




}
