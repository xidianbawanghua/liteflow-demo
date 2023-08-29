package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LayerOrder2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        System.out.println("resultList size is "+resultList.size());
        return reverse(resultList);
    }

    private List<List<Integer>> reverse(List<List<Integer>> resultList) {
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = resultList.size() - 1; i >= 0; i--) {
            newList.add(resultList.get(i));
        }
        return newList;
    }

}
