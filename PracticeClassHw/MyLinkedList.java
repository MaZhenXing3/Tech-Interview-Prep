package PracticeClassHw;


public class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //if (head == null){
        //  return -1;
        //}
        ListNode curr = head;
        while(curr != null){
            if (index-- == 0){
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode insert = new ListNode(val);
        insert.next = head;
        head = insert;
        if (tail == null){
            tail = insert;
        }
        size++;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null){
            addAtHead(val);
        }
        else{
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
        return;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        ListNode curr = head;
        ListNode insert = new ListNode(val);
        while(curr != null){
            if (--index == 0){
                insert.next = curr.next;
                curr.next = insert;
            }
            curr = curr.next;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        if (index == 0){
            ListNode node = head;
            head = head.next;
            node.next = null;
            if (head == null){
                tail = null;
            }
        }
        else{
            ListNode curr = head;
            while(curr != null){
                if (--index == 0){
                    // delete curr
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
        }
        return;
    }
    public static void main(String[] args){
        MyLinkedList list1 = new MyLinkedList();
        System.out.println(list1.get(0));
        list1.addAtHead(1);
        list1.addAtHead(2);
        list1.addAtHead(3);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println("-----------------------");
        list1.addAtIndex(2,5);
        list1.deleteAtIndex(0);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println("-----------------------");
        list1.addAtTail(100);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println(list1.get(3));

    }
}
class ListNode{
    int value;
    ListNode next;
    public ListNode(int val){
        this.value = val;
        next = null;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
