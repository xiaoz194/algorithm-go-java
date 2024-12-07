package class03_linked_list_stack_queue;

import java.util.Stack;

// 栈实现队列
// leetcode https://leetcode.cn/problems/implement-queue-using-stacks/
public class Code09_StackToConvertQueue {

    public class MyQueue {

        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        // 入栈，直接加数
        public void push(int x) {
            in.push(x);
        }

        // 出栈，1）如果out有数，in中的数不能加到out，直接从out弹出 2）out空，in全部加入out
        public int pop() {
            if(!out.isEmpty()) {
                return out.pop();
            } else {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        }

        public int peek() {
            if(!out.isEmpty()) {
                return out.peek();
            } else {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.peek();
            }
        }

        public boolean empty() {
            return in.size() == 0 && out.size() == 0;
        }
    }

}
