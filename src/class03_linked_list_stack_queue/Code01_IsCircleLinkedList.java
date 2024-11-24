package class03_linked_list_stack_queue;

/**
 * @Classname Code01_IsCircleLinkedList
 * @Description 判断一个单链表是否有环？并返回环的位置
 *
 * 解法1：采用HashSet数据结构，遍历单链表，每遍历到一个节点先判断Set中是否有该元素，若没有则加入，
 * 如果一个链表有环，必会遍历到一个节点，这个节点已经存在于Set中了，那么这个节点就是环的位置。
 *
 * 解法2：不借助额外的数据结构，快慢指针法。（此方法证明较为困难，记住算法流程）初始时快指针走2步，慢指针走1步，
 * 后面快指针一次走2步，慢指针一次走1步。如果有环，二者必在环上相遇。当两者相遇时，快指针回到头节点，慢指针位置不变，
 * 他们同时每次只移动一步，二者必相遇，这个相遇的位置，就是环的入口位置。
 *
 * @Date 2021/11/9
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_IsCircleLinkedList {
    //单链表的节点
    private static class Node {
        int val;
        Node next;
    }

    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node n1 = head.next; //s
        Node n2 = head.next.next; //f
        while(n1!=n2){
            if(n2.next==null || n2.next.next==null)
                return null;
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

}
