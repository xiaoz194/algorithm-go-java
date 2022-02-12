package class05_graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname GraphGenerator
 * @Description 根据题目给的图表示方式创建出自己的模版图
 * 例如：题目给一个N*3的矩阵matrix，含义为：
 * [weight,from节点上面的值，to节点上面的值]
 * 将其转化为我们自己熟悉的模版图结构，便于直接套算法模版
 * @Date 2022/2/10
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class GraphGenerator {

    public Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        for(int i=0;i<matrix.length;i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;

    }

}
