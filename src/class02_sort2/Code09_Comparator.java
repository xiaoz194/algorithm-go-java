package class02_sort2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Code09_Comparator
 * @Description 比较器的使用
 *
 * 1)比较器的实质就是重载比较运算符
 * 2）比较器可以很好的应用在特殊标准的排序上
 * 3）比较器可以很好的应用在根据特殊标准排序的结构上
 *
 * @Date 2021/11/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code09_Comparator {

    //学生类 自定义的结构如何比大小？ 比较器
    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    //id升序的比较器
    public static class IdAscendingComparator implements Comparator<Student>{
        //返回负数的时候，第一个参数排在前面
        //返回正数的时候，第二个参数排在前面
        //返回0的时候，谁在前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id; //o1-o2<0 -> o1<02 o1-o2>0 -> o2<o1 o1-o2=0 -> o1=o2
        }
    }

    //id降序的比较器
    public static class IdDescendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }

    //数组降序的比较器
    public static class DescendingComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {
        System.out.println("====================");

        Student s1 = new Student("A",2,21);
        Student s2 = new Student("B",1,20);
        Student s3 = new Student("C",3,22);
        Student[] s = new Student[]{s1,s2,s3};
        Arrays.sort(s,new IdAscendingComparator());
        for(Student e:s) System.out.print(e.name+e.id+e.age + " ");

        System.out.println("====================");

        Integer[] arr = {5,4,3,2,7,9,1,0};
        Arrays.sort(arr); //默认从小到大排序
        for(int e:arr) System.out.print(e+" ");
        //能否让它从大到小排序？ 使用比较器
        System.out.println();
        Arrays.sort(arr,new DescendingComparator());
        for(int e:arr) System.out.print(e+" ");
        System.out.println();
        System.out.println("======================");
        //优先级队列默认是小根堆，可以使用比较器让它构造一个大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(11);
        pq.add(7);
        pq.add(2);
        pq.add(9);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        System.out.println("==================");
        //使用比较器 构造大根堆
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new DescendingComparator());
        pq2.add(5);
        pq2.add(11);
        pq2.add(7);
        pq2.add(2);
        pq2.add(9);
        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }

    }

}
