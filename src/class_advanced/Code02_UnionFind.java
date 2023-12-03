package class_advanced;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Code02_UnionFind {

    //样本进来包一层，叫做元素
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        // k 某元素 v 某元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        // k 某集合的代表元素，v 集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        //初始化，将所有元素各自分开，初始状态下每个元素都是单独的一个集合
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }


        //给定一个ele，往上一直找，把代表元素返回
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while(element != fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            while(!path.isEmpty()){
                fatherMap.put(path.pop(),element); // 扁平化
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) { //不等才union，想等则说明a和b在一个集合中，不用union
                    //数量较少集合的顶端要挂载数量较多集合的顶端下面
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small,big);
                    sizeMap.put(big,sizeMap.get(aF) + sizeMap.get(bF));
                    fatherMap.remove(small);
                }

            }
        }

    }

}
