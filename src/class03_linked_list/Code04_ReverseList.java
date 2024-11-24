package class03_linked_list;

// 反转链表
public class Code04_ReverseList {
    private static class Node {
        int val;
        Node next;
    }
    private static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null,next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre =head;
            head = next;
        }
        return pre;
    }

}
