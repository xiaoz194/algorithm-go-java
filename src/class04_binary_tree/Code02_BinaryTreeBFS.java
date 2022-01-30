package class04_binary_tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Code02_BinaryTreeBFS
 * @Description 二叉树的广度优先遍历（层次遍历）
 * @Date 2022/1/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */

public class Code02_BinaryTreeBFS {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count>0){
                root = queue.poll();
                list.add(root.val);
                count--;
                if(root.left!=null){
                    queue.add(root.left);
                }
                if(root.right!=null){
                    queue.add(root.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}
