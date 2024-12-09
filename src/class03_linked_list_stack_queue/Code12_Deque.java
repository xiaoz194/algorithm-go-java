package class03_linked_list_stack_queue;

import java.util.Deque;
import java.util.LinkedList;

// 分别用likedList和数组 实现双端队列  重点是数组实现
// leetcode https://leetcode.cn/problems/design-circular-deque/description/
public class Code12_Deque {

    // linkedList实现
    class Deque1 {
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public Deque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                deque.pollFirst();
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                deque.pollLast();
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekLast();
            }
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }


    // 数组实现
    // 头部加入，l == 0；入的数放k-1位置，l来k-1；l != 0, 入的位置l-1，l--
    // 头部出，l == k-1,l来0位置；l != k-1, l++
    // 尾入，r == k-1，r来0，r != k-1,r来r+1位置，r++
    // 尾出，r == 0,r来k-1, r!=0, r--
    class Deque2 {
        public int[] deque;
        public int l, r, size;
        public int limit;

        public Deque2(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == (limit - 1) ? 0 : (r + 1);
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == (limit - 1) ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? (limit - 1) : (r - 1);
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[l];
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque[r];
            }
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }


}
