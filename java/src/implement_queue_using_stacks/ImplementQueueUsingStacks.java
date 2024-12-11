package leetcode.implement_queue_using_stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    private Stack<Integer> stack;
    Stack<Integer> reverse;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack = new Stack<Integer>();
        reverse =  new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {        
        while (!reverse.isEmpty())
            stack.add(reverse.pop());
        stack.add(x);
        while (!stack.isEmpty())
            reverse.add(stack.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return reverse.pop();
    }

    /** Get the front element. */
    public int peek() {
        return reverse.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverse.isEmpty();
    }
}