package class04_binary_tree;

/**
 * @Classname Code05_IsBalancedTree
 * @Description 判断一棵二叉树是否是平衡二叉树（AVL树）
 * 递归思想：
 * 左子树 必须是平衡二叉树，计算高度
 * 右子树 必须是平衡二叉树，计算高度
 * 左右的条件相同，构造相同的递归结构体
 * @Date 2022/1/31
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code05_IsBalancedTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }

    public boolean isBalanced(TreeNode root){
        return isBalancedTree(root).isBalanced;
    }

    public static class ReturnType{
        boolean isBalanced;
        int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public ReturnType isBalancedTree(TreeNode root){
        if(root == null) return new ReturnType(true,0); //base
        ReturnType leftData = isBalancedTree(root.left);
        ReturnType rightData = isBalancedTree(root.right);
        int hei = Math.max(leftData.height,rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced,hei);
    }


}
