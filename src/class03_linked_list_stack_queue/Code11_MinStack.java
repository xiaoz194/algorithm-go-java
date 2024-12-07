package class03_linked_list_stack_queue;

import java.util.Stack;

// 设计一个最小栈，有getMin()方法，可以返回最小值，要求时间复杂度O(1)
// 思路： 2个栈，一个data栈，一个min栈
// 同步压数，data栈常规压数，
// min栈压数规则：
// 1）如果当前数 <= min栈顶，min压当前数
// 2）如果当前数 > min栈顶，mih压min栈顶数
// 3）如果min栈为空，说明data栈也空，是栈空状态，同时压入
// 弹数 两个栈同时弹
public class Code11_MinStack {
    class MinStack {

        Stack<Integer> data;
        Stack<Integer> min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
