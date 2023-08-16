package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return method(root);
    }

    private List<Integer> method(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        List<Integer> resultList = new ArrayList<>();
        while (!stack.isEmpty()) {
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            resultList.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
                cur = pop.right;
            }
        }
        return resultList;
    }

}
