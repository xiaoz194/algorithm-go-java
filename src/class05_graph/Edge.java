package class05_graph;

/**
 * @Classname Edge
 * @Description 图结构中的边数据结构
 * @Date 2022/2/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;
    public Edge(int weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
