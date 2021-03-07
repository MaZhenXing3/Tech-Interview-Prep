package LinkedList;

public class ReverseLLIterative {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null, cur = head, nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
