package class03_linked_list;

// 合并两条有序链表
public class Code05_MergeSortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode c1 = head.next;
        ListNode c2 = head == list1 ? list2 : list1;
        ListNode pre = head;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                pre.next = c1;
                c1 = c1.next;
            } else {
                pre.next = c2;
                c2 = c2.next;
            }
            pre = pre.next;
        }
        pre.next = c1 == null ? c2 : c1;
        return head;
    }

}