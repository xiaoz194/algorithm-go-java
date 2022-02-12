package class05_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Code01_BFS
 * @Description 图的广度优先遍历
 * @Date 2022/2/12
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_BFS {
    public void bfs(Node node){
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next: node.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
