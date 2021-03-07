package LinkedList;

public class MergeSortLL {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode leftH = mergeSort(head);
        ListNode rightH = mergeSort(newHead);
        return merge(leftH, rightH);
    }

    private ListNode merge(ListNode leftH, ListNode rightH) {
        ListNode l = leftH;
        ListNode r = rightH;
        ListNode dummy = new ListNode(-1);
        ListNode comboH = dummy;
        while (l != null && r != null) {
            if (l.value <= r.value) {
                comboH.next = l;
                l = l.next;
            } else {
                comboH.next = r;
                r = r.next;
            }
            comboH = comboH.next;
        }
        if (l != null) {
            comboH.next = l;
        }
        if (r != null) {
            comboH.next = r;
        }
        return dummy.next;
    }
}
