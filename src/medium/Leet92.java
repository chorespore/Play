package medium;

import main.ListNode;

public class Leet92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode start = newHead;
        ListNode end = newHead;

        for (int i = 0; i < n; i++) {
            if (i < m - 1) {
                start = start.next;
            }
            end = end.next;
        }

//        System.out.print("start:");
//        Play.printList(start);
//        System.out.print("end:");
//        Play.printList(end);

        ListNode nextSeg = end.next;
        ListNode pre = start.next;
        end.next = null;
        start.next = reverse(start.next);
        pre.next = nextSeg;

        return newHead.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        return newHead;
    }
}
