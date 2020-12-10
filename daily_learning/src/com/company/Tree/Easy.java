package com.company.Tree;

/**
 * @title: Easy
 * @Author Geek_Ling
 * @Date: 2020/12/10 21:38
 * @Version 1.0
 * LeetCode关于树的题目，难度级别是easy的
 */
public class Easy {
    public static void main(String[] args) {

    }

    int ans = 0;

    /**
     * @param root
     * @param low
     * @param high
     * @return int
     * @description 938. Range Sum of BST 利用BST数的性质
     * @author Geek_Ling
     * @date 2020/12/10
     */

    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return ans;
    }

    public void inOrder(TreeNode node, int low, int high) {
//        if (node == null) return 0;
        if (node != null) {
            if (node.val > low) {
//                如果当前节点的值比low大的话，遍历左子树
                inOrder(node.left, low, high);
            }
            if (node.val >= low && node.val <= high) {
                //当前节点的值在[low,high]之间，则累加
                ans += node.val;
            }
            if (node.val < high) {
                inOrder(node.right, low, high);
            }

        }
    }
}
