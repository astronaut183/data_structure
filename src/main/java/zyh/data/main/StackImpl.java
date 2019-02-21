package zyh.data.main;

import zyh.data.service.LinkList;
import zyh.data.service.Stack;

public class StackImpl implements Stack {
    private int top;
    private LinkList linkList = new LinkListImpl();

    public StackImpl() {
        top = -1;
    }

    @Override
    public void put(int data) {
        linkList.insert(1, data);
        top++;
    }

    @Override
    public int pop() {
        int data = linkList.get(1);
        linkList.delete(1);
        top--;
        return data;
    }

    public boolean inempty() {
        return top == -1;
    }
}
