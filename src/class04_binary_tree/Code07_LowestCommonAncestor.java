package class04_binary_tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname Code07_LowestCommonAncestor
 * @Description LCA问题 给两个节点node1和node2，求他们的最低公共祖先。node1和node2必须属于一棵树。
 * 思路：可以求出每个叶子结点往上走的链 => 转化为了求两个无环单链表相交的问题 回溯法
 * @Date 2022/2/2
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code07_LowestCommonAncestor {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) { this.data = data;}
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lca(TreeNode root,TreeNode o1,TreeNode o2){
        HashMap<TreeNode,TreeNode> fatherMap = new HashMap<>();
        //设置头节点的父节点，是自己
        fatherMap.put(root,root);
        //通过回溯法获取除了头节点外所有节点的父节点
        process(root,fatherMap);
        //记录O1往上所有节点
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = o1;
        while(cur != fatherMap.get(cur)){
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(cur);
        //找到o2的链中第一个在set里的节点，即他们的最低公共祖先，如果没找到则返回null
        while(o2 != fatherMap.get(cur)){
            if(set.contains(o2)){
                return o2;
            }
            o2 = fatherMap.get(o2);
        }
        //如果前面的节点全看完了还没找到，则最后看一眼头节点
        if(set.contains(o2))
            return o2;
        return null;
    }

    //回溯法,找出除了根节点外所有节点的父亲节点
    public void process(TreeNode root,HashMap<TreeNode,TreeNode> fatherMap){
        if(root == null) return;
        fatherMap.put(root.left,root);
        fatherMap.put(root.right,root);
        process(root.left,fatherMap);
        process(root.right,fatherMap);
    }

    /**
     * 解法2 优化递归思路：
     * o1与o2的所有结构关系：
     * 1）o1是o2的lca 或 o2是o1的lca
     * 2）o1与o2不互为lca 即它们的lca是其他节点
     * **/
    public TreeNode lca2(TreeNode root,TreeNode o1,TreeNode o2){
        if(root == null || root == o1 || root == o2)
            return root;
        TreeNode leftData = lca2(root.left,o1,o2);
        TreeNode rightData = lca2(root.right,o1,o2);
        if(leftData!=null && rightData != null)
            return root;
        return leftData != null ? leftData : rightData;
    }


}
