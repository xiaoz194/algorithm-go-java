package class04_binary_tree;

/**
 * @Classname Code06_IsFullTree
 * @Description 判断一棵二叉树是不是满二叉树
 * 思路：同Code03，Code05一样的套路，树型DP思路
 * 总结 什么情况适合用树型DP套路：
 * 当整个流程都可以通过从左树和右树搜集信息来解决时，可以采用该套路
 * @Date 2022/2/2
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code06_IsFullTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class ReturnType{
        int height;
        int nodeCount;
        public ReturnType(int height, int nodeCount) {
            this.height = height;
            this.nodeCount = nodeCount;
        }
    }

    public boolean isFull(TreeNode root){
        if(root == null) return true;
        return ((1 << process(root).height)-1) == process(root).nodeCount;
    }

    public ReturnType process(TreeNode x){
        if(x == null) return new ReturnType(0,0);
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height,rightData.height)+1;
        int nodeCount = leftData.nodeCount + rightData.nodeCount + 1;
        return new ReturnType(height,nodeCount);
    }

}
