package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        methodRec(root, result, 0, new HashMap<>());
        return result;
    }

    private void methodRec(TreeNode root, List<Integer> result, int layerCount, Map<Integer, TreeNode> layerAndNodeMap) {
        if (root == null) return;
        System.out.println("root is: "+root.val);
        if (layerAndNodeMap.containsKey(layerCount)) {
            System.out.println("layerAndNodeMap contains key: "+ layerCount+", and map is:");
            printMap(layerAndNodeMap);
        } else {
            result.add(root.val);
            layerAndNodeMap.put(layerCount, root);
            printMap(layerAndNodeMap);
        }
        methodRec(root.right, result, ++layerCount, layerAndNodeMap); //注意注意注意！！⚠️，这里layerCount 不能用++！否则到下一层复制的val和上一层相等
        methodRec(root.left, result, ++layerCount, layerAndNodeMap);
    }

    private void printMap(Map<Integer, TreeNode> layerAndNodeMap) {
        for (Integer key:layerAndNodeMap.keySet()) {
            System.out.print("("+key+","+layerAndNodeMap.get(key).val+"),");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        System.out.println(map.containsKey(1));
    }
}
