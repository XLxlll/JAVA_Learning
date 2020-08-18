package com.company.leetCode;

import com.company.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @title: BFSLearning _BFS学习技巧
 * @Author Geek_Ling
 * @Date: 2020/8/17 9:17
 * @Version 1.0
 */
public class BFSLearning {
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
