package LinkedList;

public class ReverseLLRecursive {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode reverseNode = head.next;
        reverseNode.next = head;
        head.next = null;
        return newHead;
    }
}
