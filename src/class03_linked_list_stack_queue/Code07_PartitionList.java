package class03_linked_list_stack_queue;


// 划分链表
//https://leetcode.cn/problems/partition-list-lcci/
public class Code07_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode leftHead = null,leftTail = null;
        ListNode rightHead = null,rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        // < x的区域有内容
        leftTail.next = rightHead;
        return leftHead;
    }
}
