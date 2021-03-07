package QueueAndStack;

import java.util.LinkedList;
public class StackByQueues {
    private LinkedList q;
    /** Initialize your data structure here. */
    public StackByQueues() {
        q = new LinkedList<Integer>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        q.offerFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if(q.isEmpty()){
            return null;
        }
        int size = q.size();
        while(--size > 0){
            q.offerFirst(q.pollLast());
        }
        return (int)q.pollLast();
    }

    /** Get the top element. */
    public Integer top() {
        if(q.isEmpty()){
            return null;
        }
        int tmp = pop();
        q.offerFirst(tmp);
        return (int)tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q.isEmpty();
    }
    public static void main(String[] args){
        StackByQueues stack = new StackByQueues();
        stack.pop();
        System.out.println(stack.top());
        stack.push(2);
        System.out.println(stack.top());
        stack.pop();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
    }
}

