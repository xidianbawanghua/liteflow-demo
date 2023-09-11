package org.example.service.alghrithm.binaryTree;

import org.example.service.alghrithm.TreeNode;

import java.util.*;

public class BinaryTreePaths {
    List<List<TreeNode>> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        methodRec(root, new LinkedList<>());
        return convert(list);
    }

    //递归（回溯法）
    public void methodRec(TreeNode root, Deque<TreeNode> queue) {
        if (root == null) return;
        queue.offerLast(root);
        if (root.left == null && root.right == null) {
            //路径遍历完毕
            list.add(new ArrayList<>(queue));
            return;
        }
        if (root.left != null) {
            methodRec(root.left, queue);
            queue.pollLast(); //⚠️ 需要加这个，当该节点遍历结束，要接着遍历兄弟节点或返回上层（即root的父节点）时，需要该节点移出queue
        }
        if (root.right != null) {
            methodRec(root.right, queue);
            queue.pollLast(); //⚠️ 需要加这个，当该节点遍历结束，要接着遍历兄弟节点或返回上层（即root的父节点）时，需要该节点移出queue
        }
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


    public static void main(String[] args) {
        String TrainScoreRuleDTOSql = "SELECT * FROM \n" +
                "(SELECT * FROM coach_app.coach_train_score_rule WHERE `status` = 1) as A\n" +
                "LEFT JOIN\n" +
                "(SELECT rule_stage_id, rule_stage, rule_stage_rate, rule_stage_name, template_id FROM coach_app.coach_train_score_rule_stage WHERE `status` = 1) as B\n" +
                "on A.rule_stage_id = B.rule_stage_id\n" +
                "LEFT JOIN\n" +
                "(SELECT biz_id FROM coach_app.bs_coach_score_template) as C\n" +
                "on B.template_id = C.biz_id\n" +
                "WHERE B.rule_stage_id is not NULL and C.biz_id is not NULL";
        System.out.println(TrainScoreRuleDTOSql);
    }

}
