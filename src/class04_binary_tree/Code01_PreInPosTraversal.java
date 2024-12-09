package class04_binary_tree;

import java.util.Stack;

/**
 * @Classname Code01_PreInPosTraversal
 * @Description 二叉树的遍历
 * @Date 2021/11/17
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_PreInPosTraversal {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }

    //二叉树的递归序遍历，每个节点都会被访问3次
    public static void f(Node head){
        if(head == null)
            return;
        f(head.left);
        f(head.right);
    }

    public static void preOrder(Node head){
        if(head == null)
            return;
        System.out.println(head.value);
        f(head.left);
        f(head.right);
    }

    public static void preOrderSimple(Node head){
        if(head == null)
            return;
        System.out.println(head.value);
        preOrderSimple(head.left);
        preOrderSimple(head.right);
    }

    public static void inOrder(Node head){
        if(head == null)
            return;
        f(head.left);
        System.out.println(head.value);
        f(head.right);
    }

    public static void inOrderSimple(Node head){
        if(head == null)
            return;
        inOrderSimple(head.left);
        System.out.println(head.value);
        inOrderSimple(head.right);
    }

    public static void posOrder(Node head){
        if(head == null)
            return;
        f(head.left);
        f(head.right);
        System.out.println(head.value);
    }

    public static void posOrderSimple(Node head){
        if(head == null)
            return;
        posOrderSimple(head.left);
        posOrderSimple(head.right);
        System.out.println(head.value);
    }




    /**
     *  先序遍历非递归版本
     *  步骤：
     *  1）从栈中弹出一个节点cur
     *  2）打印（处理）cur
     *  3）先压右再压左（如果有）
     *  4）重复上述步骤
     */
    public static void preOrderUnRecur(Node head){
        if(head == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.value+" ");
            if(head.right != null)
                stack.push(head.right);
            if(head.left != null)
                stack.push(head.left);
        }
        System.out.println();
    }

    /**
     * 先序非递归改造后序非递归 准备2个栈
     * 1）从栈中弹出cur
     * 2）cur放入收集栈
     * 3）先压左再压右
     * 4）重复上述步骤
     * 收集完之后，从收集栈中弹出元素打印即为后序遍历
     */
    public static void posOrderUnRecur(Node head){
        if(head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            help.push(head);
            if(head.left!=null)
                stack.push(head);
            if(head.right!=null)
                stack.push(head);
        }
        while(!help.isEmpty()){
            System.out.println(help.pop().value+" ");
        }
    }

    /**
     * 中序遍历非递归
     * 每棵子树，整棵树左边界进栈，依次弹出的过程中，先打印（处理），然后判断弹出节点有无右树，
     * 若有，压栈，然后周而复始上述过程。
     * **/
    public static void inOrderUnRecur(Node head){
        if(head==null)
            return;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head!=null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.println(head.value+" "); //处理
                head = head.right;
            }
        }
        System.out.println();
    }


}
