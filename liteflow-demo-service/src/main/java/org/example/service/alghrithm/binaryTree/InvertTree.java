package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        methodRec(root);
        return root;
    }

    private void methodRec(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        methodRec(root.left);
        methodRec(root.right);
    }
}
