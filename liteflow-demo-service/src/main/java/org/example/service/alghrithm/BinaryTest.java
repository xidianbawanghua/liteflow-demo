package org.example.service.alghrithm;

import org.example.service.alghrithm.binaryTree.BinaryTreePaths;
import org.example.service.alghrithm.binaryTree.ConstructBinaryTree;

public class BinaryTest {

    public static void main(String[] args) {
        Integer[] input = {1,2,3,null,5};
        TreeNode root = ConstructBinaryTree.build(input);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        binaryTreePaths.binaryTreePaths(root);

    }
}
