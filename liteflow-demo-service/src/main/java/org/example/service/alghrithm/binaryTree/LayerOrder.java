package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LayerOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return method(root);
    }

    private List<List<Integer>> method(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                subList.add(poll.val);
                count--;
            }
            count = queue.size();
            resultList.add(subList);
        }
        return resultList;
    }

}
