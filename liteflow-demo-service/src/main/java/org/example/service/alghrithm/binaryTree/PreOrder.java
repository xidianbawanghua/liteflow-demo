package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return method(root);
    }


    private List<Integer> method(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //初始化，把root节点放入stack
        stack.push(root);
        List<Integer> resultList = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            resultList.add(pop.val);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        return resultList;
    }
}
