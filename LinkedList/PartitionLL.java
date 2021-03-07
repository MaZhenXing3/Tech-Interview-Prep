package LinkedList;

public class PartitionLL {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode largeH = new ListNode(0);
        ListNode largeCur = largeH;
        ListNode smallH = new ListNode(-1);
        ListNode smallCur = smallH;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value < target) {
                smallCur.next = cur;
                smallCur = smallCur.next;
            } else {
                largeCur.next = cur;
                largeCur = largeCur.next;
            }
            cur = cur.next;
        }
        largeCur.next = null;
        smallCur.next = largeH.next;
        return smallH.next;
    }
}
