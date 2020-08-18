package com.company.base;

import java.util.Queue;

/**
 * @title: TreeNode
 * @Author Geek_Ling
 * @Date: 2020/8/17 9:18
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public  TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
