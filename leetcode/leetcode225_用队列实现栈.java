import java.util.*;
//单队列写法

class MyStack {

    /** Initialize your data structure here. */
    int size;
    Queue<Integer> inQueue;
    public MyStack() {
        size=0;
        inQueue=new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp=size;
        while(temp-->1){
            inQueue.add(inQueue.poll());
        }
        int aim=inQueue.poll();
        size--;
        return aim;
    }

    /** Get the top element. */
    public int top() {
        int temp=size;
        while(temp-->1){
            inQueue.add(inQueue.poll());
        }
        int aim=inQueue.peek();
        inQueue.add(inQueue.poll());
        return aim;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  size==0;
    }
}
public class leetcode225_用队列实现栈 {

    public static void main(String[] args) {

    }
}
