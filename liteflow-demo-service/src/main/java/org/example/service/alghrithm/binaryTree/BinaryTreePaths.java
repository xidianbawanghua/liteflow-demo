package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.*;

public class BinaryTreePaths {
    private TreeNode lastNode;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        return convert(method(root));
    }


    private List<String> convert(List<List<TreeNode>> temp) {
        List<String> result = new ArrayList<>();
        for (List<TreeNode> subList : temp) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subList.size(); i++) {
                sb.append(subList.get(i).val);
                if (i < subList.size() - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }


    private List<List<TreeNode>> method(TreeNode root) {
        List<List<TreeNode>> tempResult = new ArrayList<>();
        TreeNode temp = root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(temp);
        while (!queue.isEmpty()) {
            while (temp.left != null) {
                queue.offerLast(temp.left);
                temp = temp.left;
            }
            if (temp.right == null) {
                //bainli完一条路径，记录
                tempResult.add(new ArrayList<>(queue));
                lastNode = queue.pollLast();
                if (lastNode == queue.peekLast().right) {
                    lastNode = queue.pollLast();
                }
            } else {
                queue.offerLast(temp.right);
                temp = temp.right;

            }
        }
        return tempResult;
    }
}
