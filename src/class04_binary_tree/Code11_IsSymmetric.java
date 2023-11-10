package class04_binary_tree;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 *          1
 *       2     2
 *    3    4  4    3
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 *          1
 *      2       2
 *         3       3
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * **/
public class Code11_IsSymmetric {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    private boolean check(TreeNode p1,TreeNode p2) {
        if (p1 == null && p2 == null)
            return true;
        if (p1 == null || p2 == null)
            return false;
        return p1.val == p2.val && check(p1.left,p2.right) && check(p1.right,p2.left);
    }

}
