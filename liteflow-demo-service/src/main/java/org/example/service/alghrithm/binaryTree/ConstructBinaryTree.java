package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTree {

    public static TreeNode build(Integer[] input) {
        if (input == null || input.length == 0) return null;
        //初始化
        Queue<TreeNode> queue = new LinkedList<>();
        int layer = 0; //记录当前层
        int count = 1; //记录当前层节点个数
        int index = 1; //记录下一个节点数值所在下标
        TreeNode root = new TreeNode(input[0]);
        queue.offer(root);


        while (index < input.length) {
            while (count > 0 && index < input.length) {
                TreeNode poll = queue.poll(); //取出队顶元素
                count--;
                poll.left = getNode(input[index], queue);
                if (++index >= input.length) return root; //数组遍历结束
                poll.right = getNode(input[index], queue);
                index++;
            }
            layer++;
            count = (int) Math.pow(2, layer);
        }
        return root;
    }

    private static TreeNode getNode(Integer val, Queue<TreeNode> queue) {
        if (val == null) return null;
        TreeNode treeNode = new TreeNode(val);
        queue.offer(treeNode);
        return treeNode;
    }

    public static void main(String[] args) {
        Integer[] input = {1,2,3,null,5};
        TreeNode build = build(input);
        System.out.println();
    }
}
