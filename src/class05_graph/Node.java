package class05_graph;

import java.util.ArrayList;

/**
 * @Classname Node
 * @Description 图结构中的节点数据结构
 * @Date 2022/2/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
    }
}
