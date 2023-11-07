package class03_linked_list;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Hash表
 * 1）哈希表在使用层面上可以理解为一种集合结构
 * 2）如果只有key，没有伴随数据value 可以使用HashSet结构
 * 3）如果既有key，也有伴随数据value 可以使用HashMap结构
 * 4）有无伴随数据，是HashSet和HashMap的唯一区别，底层的结构是实际是一回事
 * 5）HashSet是去重的
 * **/
public class Code03_HashSetAndHashMap {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(8);
        System.out.println(set.contains(7));
        System.out.println(set.contains(3));
        set.remove(3);
        System.out.println(set.contains(3));
        System.out.println("-------------------");
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"a");
        map.put(1,"b");
        map.put(2,"c");
        System.out.println(map.containsKey(0));
        map.remove(0);
        System.out.println(map.containsKey(0));
    }


}
