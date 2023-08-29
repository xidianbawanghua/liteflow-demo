package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

public class CountNodes {
    int result = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        methodRec(root);
        return result;
    }

    private void methodRec(TreeNode root) {
        if (root == null) return;
        int leftMaxLayer = getMaxLayer(root.left);
        int rightMaxLayer = getMaxLayer(root.right);
        if (leftMaxLayer > rightMaxLayer) {
            //说明右子树为满二叉树
            result = result + (int) Math.pow(2, rightMaxLayer);
            methodRec(root.left);
        } else if (leftMaxLayer == rightMaxLayer) {
            //说明左子树为满二叉树
            result = result + (int) Math.pow(2, rightMaxLayer);
            methodRec(root.right);
        }
    }

    private int getMaxLayer(TreeNode root) {
        if (root == null) return 0;
        int result = 1;
        TreeNode temp = root;
        while (temp.left != null) {
            result++;
            temp = temp.left;
        }
        return result;
    }
}
