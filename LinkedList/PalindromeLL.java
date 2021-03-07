package LinkedList;

public class PalindromeLL {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode firstHalf = head;
        ListNode reversedHalf = reverse(secondHalf);
        while (firstHalf != null && reversedHalf != null) {
            if (firstHalf.value != reversedHalf.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedHalf = reversedHalf.next;
        }
        return true;
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
