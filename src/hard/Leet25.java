package hard;

import main.ListNode;


public class Leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode end = head;

        for (int i = 1; i < k && end != null; i++) {
            end = end.next;
        }
        if (end != null) {
            ListNode nextSeg = end.next;
            end.next = null;
            head = reverse(head);
            pre.next = reverseKGroup(nextSeg, k);
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        return newHead;
    }

/*    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }*/

}
