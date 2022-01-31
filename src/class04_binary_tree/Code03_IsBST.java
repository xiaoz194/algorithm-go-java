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

    public boolean isBST(Node head){
        if(head == null) return true;
        boolean isLeftBST = isBST(head.left);
        if(!isLeftBST) return false;
        if(head.val <= preVal){
            return false;
        }else{
            preVal = head.val;
        }
        return isBST(head.right);
    }

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

}
