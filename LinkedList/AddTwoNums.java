package LinkedList;

public class AddTwoNums {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode resultCur = dummy;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            int result = l1.value + l2.value + carryOver;
            resultCur.next = new ListNode(result % 10);
            carryOver = result / 10;
            resultCur = resultCur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && l2 == null) {
            int result = l1.value + carryOver;
            resultCur.next = new ListNode(result % 10);
            carryOver = result / 10;
            resultCur = resultCur.next;
            l1 = l1.next;
        }
        while (l1 == null && l2 != null) {
            int result = l2.value + carryOver;
            resultCur.next = new ListNode(result % 10);
            carryOver = result / 10;
            resultCur = resultCur.next;
            l2 = l2.next;
        }
        if (carryOver != 0) {
            resultCur.next = new ListNode(carryOver);
        }
        return dummy.next;
    }
}
