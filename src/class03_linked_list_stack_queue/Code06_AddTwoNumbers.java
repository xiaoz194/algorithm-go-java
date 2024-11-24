package class03_linked_list_stack_queue;

// 两数相加 链表相加
public class Code06_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return pre.next;
    }
}
