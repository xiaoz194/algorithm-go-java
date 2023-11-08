package class04_binary_tree;


/**
 * 求线索二叉树某一个节点的后继节点
 * 二叉树的中序遍历的序列中，node的下一个节点叫做node的后继节点
 *
 * @Date 2023/11/8
 **/
public class Code10_SuccessorNode {
    /**
     * 现有一种新的二叉树节点类型如下，
     * 该结构比普通二叉树结构多一个指向当前节点父节点的parent指针
     * 树中的每个节点的parent指针都正确的指向自己的父节点，头节点的parent指针指向null
     * 只给一个二叉树中的某个节点node，请实现返回node的后继节点的函数
     **/
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent; // 父指针 记录当前节点的父节点

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 对于任一节点：
     * 1）如果有右子树，后继节点一定是右子树上的最左节点
     * 2）如果没右子树，后继节点一定是第一个靠右的(祖)父节点
     **/
    public static Node getSuccessorNode(Node node) {
        if (node == null) return node;
        if (node.right!=null){ //有右树，找右树的最左节点
            return getLeftMost(node);
        } else { // 无右树，则向上找
            Node parent = node.parent;
            while(parent!=null && parent.left != node) {  //找第一个右折的节点 如果一直没找到则说明这个node一定是全树最右的节点，后继则为null
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    //找到以node为子树的最左节点
    public static Node getLeftMost(Node node) {
        if (node == null) return node;
        while (node.left != null)
            node = node.left;
        return node;
    }


}
