package org.example.service.alghrithm.binaryTree;

import com.sun.media.sound.SoftTuning;
import org.example.service.alghrithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class IsBalanced {
    Map<TreeNode, Integer> heightMap = new HashMap<>();
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        methodRec(root);
        return result;
    }

    //后序遍历二叉树，记录每个节点的高度
    private void methodRec(TreeNode root) {
        if (!result || root == null) return;
        methodRec(root.left);
        methodRec(root.right);
        System.out.println("root is :"+root.val);
        printMap(heightMap);
        int leftHeight = (root.left == null || heightMap.get(root.left) == null) ? 0 : heightMap.get(root.left);
        int rightHeight = (root.right == null || heightMap.get(root.right) == null) ? 0 : heightMap.get(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
            return;
        }

        heightMap.put(root, Math.max(leftHeight, rightHeight) + 1);
    }

    private void printMap(Map<TreeNode, Integer> heightMap) {
        for (TreeNode key : heightMap.keySet()) {
            System.out.print(key.val+" -> ");
            System.out.print(heightMap.get(key) + ";");
        }
        System.out.println();
    }


}
