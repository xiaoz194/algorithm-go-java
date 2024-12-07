package class03_linked_list_stack_queue;

// leetcode: https://leetcode.cn/problems/design-circular-queue/
public class Code08_CircleQueue {

    public class CircleQueue {
        int[] queue;
        int l,r,size,limit;

        public CircleQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        // size < limit 时，入队，尾++，size++，如结束，回0
        // size > 0 时，出队，头++，size--，如结束，回0
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                queue[r]  = value;
                r = r == (limit - 1) ? 0 : (r+1);
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == (limit - 1) ? 0 : (l+1);
                size--;
                return true;
            }
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[l];
            }
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                int last = r == 0 ? (limit - 1) : (r-1);
                return queue[last];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

    }




}
