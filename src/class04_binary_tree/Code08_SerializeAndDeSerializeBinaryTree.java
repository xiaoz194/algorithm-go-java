package class04_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Code08_SerializeAndDeSerializeBinaryTree
 * @Description 二叉树的序列化和反序列化
 * 采用先序遍历的方式序列化和反序列化二叉树，同理，可以采用其他方式来做。
 * @Date 2022/2/3
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code08_SerializeAndDeSerializeBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<values.length;i++){
            queue.add(values[i]);
        }
        return process(queue);
    }

    public TreeNode process(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = process(queue);
        head.right = process(queue);
        return head;
    }

}
