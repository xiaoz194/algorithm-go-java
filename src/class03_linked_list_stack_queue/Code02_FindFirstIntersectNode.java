package class03_linked_list_stack_queue;

/**
 * @Classname Code02_FindFirstIntersectNode
 * @Description 单链表相交问题
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。若两个单链表相交，返回第一个相交的元素，
 * 否则返回null
 * 要求：如果两个链表长度之和为n，时间复杂度请达到O(n)，空间复杂度请达到O(1)
 * 1）head1，head2均无环：遍历两个链表，记录他们各自的长度l1，l2，找到最后一个节点end1，end2，若
 * end1！=end2，则说明head1和head2平行，不相交，否则，head1先走l2-l1步（相差步，使得两链表在相同起跑线），
 * 然后head1和head2同时走，找到第一个相交的节点返回。
 * 2）head1和head2一个有环一个无环，该情况两个链表不可能相交，直接返回null
 * 3）head1和head2均有环，有三种情况
 * i）两个有环链表平行
 * ii）共用环，入环节点一个 解法同方法1，认为入环位置是终止节点，先让长的链表走相差步，接着同时往下走，
 *    找到第一个相交的节点返回 可以复用无环链表的代码
 * iii）功用环，不同的入环节点  让链表1一直往下走，回到环的入口处如果遇到链表2的相交点，则说明有相交，任意返回一个都可，若
 * 没有遇到，则说明两个有环链表不相交
 *
 * @Date 2021/11/9
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_FindFirstIntersectNode {

    private static class Node {
        int val;
        Node next;
    }

    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null ||head2 ==null)
            return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null)
            return noLoop(head1,head2);
        if(loop1!=null && loop2!=null)
            return bothLoop(head1,loop1,head2,loop2);
        return null;
    }

    private static Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null) return null;
        Node n1 = head.next;
        Node n2 = head.next.next;
        while(n1!=n2){
            if(n1.next==null||n1.next.next==null) return null;
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

    //当两个链表都没有环的情况
    private static Node noLoop(Node head1,Node head2){
        if(head1==null || head2==null) return null;
        Node cur1 =head1,cur2 = head2;
        int n = 0; //n为链表1长度减去链表2长度的值
        while(cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1!=cur2) return null;
        //比较哪一个链表长
        cur1 = n>0 ? head1 : head2; //谁长，谁的头给n1
        cur2 = cur1==head1 ? head2 : head1; //短的链表，头给n2
        n = Math.abs(n);
        if(n!=0){ //先让head1走相差步,让其和head2在同一起跑线
            n--;
            cur1 = cur1.next;
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个链表都有环的情况，如果相交返回，不相交返回null 分三种情况
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1==loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n>0 ? head1 : head2;
            cur2 = cur1==head1 ? head2 : head1;
            n = Math.abs(n);
            while(n!=0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1==loop2)
                    return loop1;
                cur1 = cur1.next;
            }
            return null;
        }

    }


}
