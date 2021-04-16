package cn.wjs.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历：按照访问根节点——左子树——右子树的方式遍历这棵树
 *
 */
public class Preorder {

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res){
        if(root == null){
           return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }

    }
}
