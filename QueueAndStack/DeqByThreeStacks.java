package QueueAndStack;

import java.util.Deque;
import java.util.ArrayDeque;
public class DeqByThreeStacks {
    /*
    Java: Implement a deque by using three stacks.
    The queue should provide size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations.
    When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return null.
     */
    // use three stacks
    // s1: left; s2: right; s3: buffer;
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Deque<Integer> buffer;
    public DeqByThreeStacks() {
        // Write your solution here.
        s1 = new ArrayDeque<Integer>();
        s2 = new ArrayDeque<Integer>();
        buffer = new ArrayDeque<Integer>();
    }

    public void offerFirst(int element) {
        s1.offerFirst(element);
    }

    public void offerLast(int element) {
        s2.offerFirst(element);
    }

    public Integer pollFirst() {
        if(s1.isEmpty()){
            move(s2, s1);
        }
        return s1.pollFirst();
    }

    public Integer pollLast() {
        if(s2.isEmpty()){
            move(s1, s2);
        }
        return s2.pollFirst();
    }

    public Integer peekFirst() {
        if(s1.isEmpty()){
            move(s2, s1);
        }
        return s1.peekFirst();
    }

    public Integer peekLast() {
        if(s2.isEmpty()){
            move(s1,s2);
        }
        return s2.peekFirst();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    private void move(Deque<Integer> src, Deque<Integer> des){
        // know buffer in here;
        if (src.isEmpty()){
            return;
        }
        // move all to des
        while(!src.isEmpty()){
            des.offerFirst(src.pollFirst());
        }
        // move half des to buffer
        int half = (des.size()+1) / 2;
        while(half-- > 0){
            buffer.offerFirst(des.pollFirst());
        }
        // all des to src
        while(!des.isEmpty()){
            src.offerFirst(des.pollFirst());
        }
        // all buff to des
        while(!buffer.isEmpty()){
            des.offerFirst(buffer.pollFirst());
        }
    }
    public static void main(String[] args){
        DeqByThreeStacks dq = new DeqByThreeStacks();
        System.out.println(dq.size());
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        dq.offerFirst(1);
        dq.offerFirst(2);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        System.out.println(dq.pollLast());
        System.out.println(dq.pollFirst());
        System.out.println(dq.size());
    }

}