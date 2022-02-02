package class04_binary_tree;

import java.util.Stack;

/**
 * @Classname Code03_IsBST
 * @Description 判断一棵树是不是搜索二叉树，由于搜索二叉树的中序遍历一定是一个升序的排列，因此根据中序遍历的模版来改
 * @Date 2022/1/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code03_IsBST {
    public static class Node{
        public int val;
        public Node left;
        public Node right;
    }

    public long preVal = Long.MIN_VALUE; //记录遍历过程中上次遇到的数

    /**
     * 解法1 常规的递归解法
     * **/
    public boolean isBSTRecur(Node head){
        if(head == null) return true;
        boolean isLeftBST = isBSTRecur(head.left);
        if(!isLeftBST) return false;
        if(head.val <= preVal){
            return false;
        }else{
            preVal = head.val;
        }
        return isBSTRecur(head.right);
    }

    /**
     * 解法2 非递归解法
     * **/
    public boolean isBSTUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            long preVal = Long.MIN_VALUE;
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.add(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(head.val <= preVal){
                        return false;
                    }else {
                        preVal = head.val;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    /**
     * 解法3
     * 递归思路：x当前节点的值
     * 1.左子树是二叉搜索树
     * 2.右子树是二叉搜索树
     * 3.左max < x
     * 4.右min > x
     * 套路：封装一个ReturnType：是否是BST，min value，max value
     * **/
    public boolean isBST(Node root){
        return process(root).isB;
    }

    private ReturnType process(Node x) {
        if(x == null) return null;
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int max = x.val;
        int min = x.val;
        if(leftData!=null){
            max = Math.max(leftData.max,max);
            min = Math.min(leftData.min,min);
        }
        if(rightData!=null){
            max = Math.max(rightData.max,max);
            min = Math.min(rightData.min,min);
        }
        boolean isB = true;
        if(leftData != null && (!leftData.isB || leftData.max>=x.val)){
            isB = false;
        }
        if(rightData != null &&(!rightData.isB || rightData.min <= x.val)){
            isB = false;
        }
        return new ReturnType(isB,max,min);
    }

    public static class ReturnType{
        boolean isB;
        int max;
        int min;
        public ReturnType(boolean isB, int max, int min) {
            this.isB = isB;
            this.max = max;
            this.min = min;
        }
    }

}
