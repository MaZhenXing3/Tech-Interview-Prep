package LinkedList;

public class ReorderLL {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode frontH = head;
        ListNode secondH = slow.next;
        slow.next = null;
        secondH = reverse(secondH);
        return combine(frontH, secondH);
    }

    private ListNode combine(ListNode frontH, ListNode secondH) {
        ListNode dummy = new ListNode(-1);
        ListNode newCur = dummy;
        ListNode frontCur = frontH;
        ListNode secondCur = secondH;
        while (frontCur != null && secondCur != null) {
            newCur.next = frontCur;
            frontCur = frontCur.next;
            newCur.next.next = secondCur;
            secondCur = secondCur.next;
            newCur = newCur.next.next;
        }
        if (frontCur != null) {
            newCur.next = frontCur;
        }
        if (secondCur != null) {
            newCur.next = secondCur;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
