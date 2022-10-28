package question;

/**
 * @Classname 环形链表
 * @Description 141
 * @Date 2022/8/18
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class 环形链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode s = head;
        ListNode f = head.next;
        while(s != f){
            if(f.next == null || f.next.next == null){
                return false;
            }
            s = s.next;
            f = f.next.next;
        }
        return true;
    }
}
