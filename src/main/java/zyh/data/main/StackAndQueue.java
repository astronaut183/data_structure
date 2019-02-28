package zyh.data.main;

import java.util.ArrayDeque;

public class StackAndQueue {
    public void TwoStackBeQueue() {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        add(stack1, 1);
        add(stack1, 2);
        add(stack1, 3);
        add(stack1, 4);
        System.out.println(pop(stack1, stack2));
        add(stack1, 5);
        System.out.println(pop(stack1, stack2));
    }

    public boolean add(ArrayDeque<Integer> stack1, int data) {
        stack1.addFirst(data);
        return true;
    }

    public int pop(ArrayDeque<Integer> stack1, ArrayDeque<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.addFirst(stack1.removeFirst());
        }
        int result = stack2.removeFirst();
        while (!stack2.isEmpty()) {
            stack1.addFirst(stack2.removeFirst());
        }
        return result;
    }


    public void TwoQueueBeStack() {
        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        stackPush(queue1,1);
        stackPush(queue1,2);
        stackPush(queue1,3);
        stackPush(queue1,4);
        System.out.println(stackPop(queue1,queue2));
        System.out.println(stackPop(queue1,queue2));
        System.out.println(stackPop(queue1,queue2));
    }

    public void stackPush(ArrayDeque<Integer> queue1, int data) {
        queue1.addFirst(data);
    }

    public int stackPop(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2){
        while(queue1.size()>1){
            queue2.addFirst(queue1.removeLast());
        }
        int result = queue1.removeLast();
        while (!queue2.isEmpty()){
            queue1.addFirst(queue2.removeLast());
        }
        return result;
    }
}
