package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    int min = -1;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
//        methodRec(root, 0);
//        return min;
        return method(root);
    }

    //递归，前序遍历
    private void methodRec(TreeNode root, int layer) {
        if (root == null) return;
        layer = layer + 1;
        if (root.left == null && root.right == null && (min == -1 || min > layer)) {
            min = layer;
        }
        methodRec(root.left, layer);
        methodRec(root.right, layer);
    }

    //层序遍历
    private int method(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            while (count > 0) {
                TreeNode poll = queue.poll();
                count--;
                if (poll.left == null && poll.right == null) return layer;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            count = queue.size();
            layer++;
        }
        return layer;
    }

}
