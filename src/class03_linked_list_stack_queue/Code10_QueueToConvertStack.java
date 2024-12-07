package class03_linked_list_stack_queue;

import java.util.LinkedList;

// 队列实现栈
// https://leetcode.cn/problems/implement-stack-using-queues/
public class Code10_QueueToConvertStack {

    // 思路： 可以一个队列实现； pop正常pop，
    // push ： 先算一下当前队列有多少元素，得到size，然后加入x，循环 把size个数一一出队入队
    public class MyStack {

        LinkedList<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            for (int i=0;i<size;i++) {
                int xx = queue.poll();
                queue.add(xx);
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }



}
