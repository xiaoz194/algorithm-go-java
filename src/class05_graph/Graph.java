package class05_graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname Graph
 * @Description 图数据结构
 * @Date 2022/2/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Graph {

    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<Integer, Node>();
        edges = new HashSet<Edge>();
    }

}
