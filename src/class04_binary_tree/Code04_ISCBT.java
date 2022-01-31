package class04_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Code04_ISCBT
 * @Description 给定一个二叉树的 root ，确定它是否是一个完全二叉树。 整体思路采用BFS方法
 * 是否是CBT的条件：
 * 1）任一节点，有右无左 false
 * 2）在满足1）的前提下，如果遇到了第一个左右子树不双全，后续都必须是叶子节点
 * @Date 2022/1/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code04_ISCBT {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            TreeNode left = root.left;
            TreeNode right = root.right;

            if(
                    (leaf && (left!=null || right!=null))
                            ||
                            (left==null && right!=null)
            ){
                return false;
            }

            if(left != null){
                queue.add(left);
            }
            if(right != null){
                queue.add(right);
            }
            if(left == null || right == null){
                leaf = true;
            }
        }
        return true;
    }

}
