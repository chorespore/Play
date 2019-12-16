package medium;

import main.ListNode;

public class Leet143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int cnt = 0;
        while (p2.next != null) {
            if (cnt++ % 2 == 1) {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        ListNode right = p1.next;
        ListNode left = head;
        p1.next = null;
        right = reverse(right);

        while (left != null && right != null) {
            ListNode nextLeft = left.next;
            ListNode nextRight = right.next;
            left.next = right;
            right.next = nextLeft;
            left = nextLeft;
            right = nextRight;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
