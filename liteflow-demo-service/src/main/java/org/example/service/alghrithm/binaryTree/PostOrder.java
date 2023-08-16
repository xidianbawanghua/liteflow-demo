package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.*;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return method2(root);
    }

    private List<Integer> method(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> resultList = new ArrayList<>();
        Set<TreeNode> tempSet = new HashSet<>();
        while (!stack.empty()) {
            TreeNode peek = stack.peek();
            if ((peek.right == null || tempSet.contains(peek.right)) && (peek.left == null || tempSet.contains(peek.left))) {
                TreeNode pop = stack.pop();
                resultList.add(pop.val);
                tempSet.add(pop);
            }
            if (peek.right != null && !tempSet.contains(peek.right)) stack.push(peek.right);
            if (peek.left != null && !tempSet.contains(peek.left)) stack.push(peek.left);
        }
        return resultList;
    }

    //优化：节省O(n)空间
    private List<Integer> method2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        stack.push(root);
        boolean flag = false; //标识当前peek节点的孩子是否已被访问
        TreeNode cur = stack.peek();
        //初始化
        while (!stack.isEmpty()) {
            while ((cur.left != null || cur.right != null) && !flag) {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
                cur = stack.peek();
            }
            TreeNode pop = stack.pop();
            resultList.add(pop.val);
            if (stack.isEmpty()) return resultList;
            cur = stack.peek();
            if (pop == cur.left || pop == cur.right) {
                flag = true;
            } else {
                flag = false;
            }
            //在栈中，当前节点和紧邻着右边的节点，关系只有两种可能（当前left，右边right/当前父，右边child，
            //若为父子，说明当前节点孩子已被遍历，无需重复入栈！ ）
        }
        return resultList;
    }


}
