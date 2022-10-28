package question;

/**
 * @Classname 反转链表
 * @Description 206. 反转链表给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Date 2022/8/17
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */



public class 反转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null,cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
