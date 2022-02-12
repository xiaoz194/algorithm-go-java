package class05_graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Classname Code02_DFS
 * @Description 图的深度优先遍历 回溯法
 * @Date 2022/2/12
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_DFS {
    public void dfs(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next:cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }

}
